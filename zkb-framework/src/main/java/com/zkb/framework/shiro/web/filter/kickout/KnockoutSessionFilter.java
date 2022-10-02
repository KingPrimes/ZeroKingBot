package com.zkb.framework.shiro.web.filter.kickout;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zkb.common.constant.ShiroConstants;
import com.zkb.common.core.domain.AjaxResult;
import com.zkb.common.core.domain.entity.SysUser;
import com.zkb.common.utils.ServletUtils;
import com.zkb.common.utils.ShiroUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 登录账户控制过滤器
 * 
 * @author KingPrimes
 */
public class KnockoutSessionFilter extends AccessControlFilter
{
    private final static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 同一个用户最大会话数
     **/
    private int maxSession = -1;

    /**
     * 踢出之前登录的/之后登录的用户 默认false踢出之前登录的用户
     **/
    private Boolean knockoutAfter = false;

    /**
     * 踢出后到的地址
     **/
    private String knockoutUrl;

    private SessionManager sessionManager;
    private Cache<String, Deque<Serializable>> cache;

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception
    {
        Subject subject = getSubject(request, response);
        if (!subject.isAuthenticated() && !subject.isRemembered() || maxSession == -1)
        {
            // 如果没有登录或用户最大会话数为-1，直接进行之后的流程
            return true;
        }
        try
        {
            Session session = subject.getSession();
            // 当前登录用户
            SysUser user = ShiroUtils.getSysUser();
            String loginName = user.getUserName();
            Serializable sessionId = session.getId();

            // 读取缓存用户 没有就存入
            Deque<Serializable> deque = cache.get(loginName);
            if (deque == null)
            {
                // 初始化队列
                deque = new ArrayDeque<>();
            }

            // 如果队列里没有此sessionId，且用户没有被踢出；放入队列
            if (!deque.contains(sessionId) && session.getAttribute("kick-out") == null)
            {
                // 将sessionId存入队列
                deque.push(sessionId);
                // 将用户的sessionId队列缓存
                cache.put(loginName, deque);
            }

            // 如果队列里的sessionId数超出最大会话数，开始踢人
            while (deque.size() > maxSession)
            {
                // 是否踢出后来登录的，默认是false；即后者登录的用户踢出前者登录的用户；
                Serializable knockoutSessionId = knockoutAfter ? deque.removeFirst() : deque.removeLast();
                // 踢出后再更新下缓存队列
                cache.put(loginName, deque);

                try
                {
                    // 获取被踢出的sessionId的session对象
                    Session knockoutSession = sessionManager.getSession(new DefaultSessionKey(knockoutSessionId));
                    if (null != knockoutSession)
                    {
                        // 设置会话的kick-out属性表示踢出了
                        knockoutSession.setAttribute("kick-out", true);
                    }
                }
                catch (Exception e)
                {
                    // 面对异常，我们选择忽略
                }
            }

            // 如果被踢出了，(前者或后者)直接退出，重定向到踢出后的地址
            if (session.getAttribute("kick-out") != null && (Boolean) session.getAttribute("kick-out"))
            {
                // 退出登录
                subject.logout();
                saveRequest(request);
                return isAjaxResponse(request, response);
            }
            return true;
        }
        catch (Exception e)
        {
            return isAjaxResponse(request, response);
        }
    }

    private boolean isAjaxResponse(ServletRequest request, ServletResponse response) throws IOException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (ServletUtils.isAjaxRequest(req))
        {
            AjaxResult ajaxResult = AjaxResult.error("您已在别处登录，请您修改密码或重新登录");
            ServletUtils.renderString(res, objectMapper.writeValueAsString(ajaxResult));
        }
        else
        {
            WebUtils.issueRedirect(request, response, knockoutUrl);
        }
        return false;
    }

    public void setMaxSession(int maxSession)
    {
        this.maxSession = maxSession;
    }

    public void setKnockoutAfter(boolean knockoutAfter)
    {
        this.knockoutAfter = knockoutAfter;
    }

    public void setKnockoutUrl(String knockoutUrl)
    {
        this.knockoutUrl = knockoutUrl;
    }

    public void setSessionManager(SessionManager sessionManager)
    {
        this.sessionManager = sessionManager;
    }

    // 设置Cache的key的前缀
    public void setCacheManager(CacheManager cacheManager)
    {
        // 必须和ehcache缓存配置中的缓存name一致
        this.cache = cacheManager.getCache(ShiroConstants.SYS_USERCACHE);
    }
}