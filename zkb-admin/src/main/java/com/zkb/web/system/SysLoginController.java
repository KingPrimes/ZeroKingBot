package com.zkb.web.system;

import com.zkb.common.core.controller.BaseController;
import com.zkb.common.core.domain.AjaxResult;
import com.zkb.common.utils.ServletUtils;
import com.zkb.common.utils.ShiroUtils;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.ip.IpUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录验证
 * 
 * @author zkb
 */
@Controller
public class SysLoginController extends BaseController
{

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap mmap)
    {
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request))
        {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }

        if(IpUtils.isHost()){
            UsernamePasswordToken token = new UsernamePasswordToken("localhost","localhost",false);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);

            // 菜单导航显示风格
            String menuStyle = "default";

            // 移动端，默认使左侧导航菜单，否则取默认配置
            String indexStyle = ServletUtils.checkAgentIsMobile(ServletUtils.getRequest().getHeader("User-Agent")) ? "index" : menuStyle;

            // 优先Cookie配置导航菜单
            Cookie[] cookies = ServletUtils.getRequest().getCookies();
            for (Cookie cookie : cookies)
            {
                if (StringUtils.isNotEmpty(cookie.getName()) && "nav-style".equalsIgnoreCase(cookie.getName()))
                {
                    indexStyle = cookie.getValue();
                    break;
                }
            }
            return "topnav".equalsIgnoreCase(indexStyle) ? "index-topnav" : "index";
        }
        // 是否开启记住我
        //mmap.put("isRemembered", rememberMe);
        // 是否开启用户注册
        mmap.put("isAllowRegister", true);
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password)
    {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password,false);
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(token);
            return success();
        }
        catch (AuthenticationException e)
        {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }

    @GetMapping("/unauth")
    public String unauth()
    {
        return "error/unauth";
    }
}
