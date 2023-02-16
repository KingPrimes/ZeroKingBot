package com.zkb.bot.domain.xmsj.model.service;

import com.alibaba.fastjson2.JSONObject;
import com.zkb.bot.domain.xmsj.model.IXmsjApi;
import com.zkb.bot.domain.xmsj.model.res.MusicXmsjResponseBody;
import com.zkb.bot.domain.xmsj.model.vo.Body;
import com.zkb.bot.domain.xmsj.model.vo.ResultSets;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.http.HttpUtils;
import okhttp3.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

@Service
public class XmsjApi implements IXmsjApi {

    Logger log = LoggerFactory.getLogger(XmsjApi.class);

    @Autowired
    RedisCache redisCache;

    /**
     * 根据歌曲名称查询歌曲
     *
     * @param name    歌曲名称
     * @param groupID 群组ID
     * @param userID  用户ID
     * @return 结果集
     */
    @Override
    public ResultSets queryMusics(String name, Long groupID, Long userID) {
        log.info("点歌-- 歌名:{},群组:{},用户:{}",name,groupID,userID);
        try{
            name = URLEncoder.encode(name,"UTF-8");
            String pram = "input=" + name + "&filter=name&type=qq&page=1";
            String url = "http://www.xmsj.org/";
            Headers.Builder builder = new Headers.Builder();
            builder.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36 Edg/110.0.1587.46");
            builder.add("X-Requested-With", "XMLHttpRequest");
            String body = HttpUtils.sendPostOkHttpToFormU(url, pram, builder.build());
            MusicXmsjResponseBody musicXmsjResponseBody = JSONObject.parseObject(body, MusicXmsjResponseBody.class);
            redisCache.setCacheObject(groupID+ "-" + userID, musicXmsjResponseBody, 2L, TimeUnit.MINUTES);
            ResultSets rs = ResultSets.builder();
            int i =0;
            for (Body datum : musicXmsjResponseBody.getData()) {
                rs.add(i,datum.getTitle(),datum.getAuthor());
                i++;
            }
            return rs;
        }catch (Exception e){
            return null;
        }

    }

    /**
     * 根据ID返回歌曲详情
     *
     * @param groupID 群组ID
     * @param userID  用户ID
     * @param msg     消息
     * @return 歌曲详情
     */
    @Override
    public Body reqSong(Long groupID, Long userID, String msg) throws Exception{
        if(StringUtils.isNumber(msg)){
            MusicXmsjResponseBody xmsj = redisCache.getCacheObject(groupID + "-" + userID);
            if(xmsj!=null){
                return xmsj.getData().get(Integer.parseInt(msg));
            }else {
                throw new Exception("cache time out!");
            }
        }
        throw new NumberFormatException("msg is not number Err:"+msg);
    }
}
