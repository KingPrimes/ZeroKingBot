package com.zkb.framework.shiro.service;


import com.zkb.common.utils.StringUtils;
import com.zkb.framework.shiro.session.OnlineSession;
import com.zkb.system.domain.SysUserOnline;
import com.zkb.system.service.ISysUserOnlineService;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 会话db操作处理
 *
 * @author KingPrimes
 */
@Component
public class SysShiroService {
    @Autowired
    private ISysUserOnlineService onlineService;

    /**
     * 删除会话
     *
     * @param onlineSession 会话信息
     */
    public void deleteSession(OnlineSession onlineSession) {
        onlineService.deleteOnlineById(String.valueOf(onlineSession.getId()));
    }

    /**
     * 获取会话信息
     */
    public Session getSession(Serializable sessionId) {
        SysUserOnline userOnline = onlineService.selectOnlineById(String.valueOf(sessionId));
        return StringUtils.isNull(userOnline) ? null : createSession(userOnline);
    }

    public Session createSession(SysUserOnline userOnline) {
        OnlineSession onlineSession = new OnlineSession();
        if (StringUtils.isNotNull(userOnline)) {
            onlineSession.setId(userOnline.getSessionId());
            onlineSession.setHost(userOnline.getIpaddr());
            onlineSession.setBrowser(userOnline.getBrowser());
            onlineSession.setOs(userOnline.getOs());
            onlineSession.setLoginName(userOnline.getLoginName());
            onlineSession.setStartTimestamp(new Date(userOnline.getStartTimestamp()));
            onlineSession.setLastAccessTime(new Date(userOnline.getLastAccessTime()));
            onlineSession.setTimeout(userOnline.getExpireTime());
        }
        return onlineSession;
    }
}
