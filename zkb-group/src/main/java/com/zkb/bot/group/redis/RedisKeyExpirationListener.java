package com.zkb.bot.group.redis;

import com.mikuac.shiro.core.BotContainer;
import com.zkb.bot.group.doa.GroupVerify;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.PrivateAddApi;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.StaticFinal;
import com.zkb.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    @Autowired
    private BotContainer botContainer;

    @Autowired
    private RedisCache redisCache;

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String key = message.toString();
        if (key.contains("code:")) {
            String userid = StringUtils.getSubString(key, "code:", "-");
            GroupVerify gv = redisCache.getCacheObject("v-code:" + userid);
            botContainer.robots.get(gv.getBotId()).setGroupKick(gv.getGroupId(), gv.getUserId(), true);
            botContainer.robots.get(gv.getBotId()).sendGroupMsg(gv.getGroupId(), Msg.builder().text("由于《" + PrivateAddApi.getPrivateNick(gv.getUserId()) + "》未发送验证码！\n被踢出该群组！").build(), false);
            for (Long user : StaticFinal.JOINGROUPVERIFYCODE.keySet()) {
                if (user == gv.getUserId()) {
                    StaticFinal.JOINGROUPVERIFYCODE.remove(user);
                    break;
                }
            }
            redisCache.deleteObject("v-code:" + userid);
        }
    }
}
