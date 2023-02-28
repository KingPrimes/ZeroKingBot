package com.zkb.framework.shiro.service;


import com.zkb.common.constant.Constants;
import com.zkb.common.constant.UserConstants;
import com.zkb.common.core.domain.entity.SysUser;
import com.zkb.common.enums.UserStatus;
import com.zkb.common.exception.user.UserBlockedException;
import com.zkb.common.exception.user.UserDeleteException;
import com.zkb.common.exception.user.UserNotExistsException;
import com.zkb.common.exception.user.UserPasswordNotMatchException;
import com.zkb.common.utils.MessageUtils;
import com.zkb.common.utils.StringUtils;
import com.zkb.framework.manager.AsyncManager;
import com.zkb.framework.manager.factory.AsyncFactory;
import com.zkb.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 登录校验方法
 *
 * @author KingPrimes
 */
@Component
public class SysLoginService {
    @Autowired
    private SysPasswordService passwordService;

    @Autowired
    private ISysUserService userService;


    /**
     * 登录
     */
    public SysUser login(String username, String password) {
        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("not.null")));
            throw new UserNotExistsException();
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserPasswordNotMatchException();
        }

        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserPasswordNotMatchException();
        }

        // 查询用户信息
        SysUser user = userService.selectUserByLoginName(username);


        if (user == null) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.not.exists")));
            throw new UserNotExistsException();
        }

        if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.delete")));
            throw new UserDeleteException();
        }

        if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.blocked", user.getRemark())));
            throw new UserBlockedException();
        }

        passwordService.validate(user, password);

        AsyncManager.me()
                .execute(
                        AsyncFactory
                                .recordLogininfor(
                                        username,
                                        Constants.LOGIN_SUCCESS,
                                        MessageUtils.message("user.login.success")
                                )
                );
        recordLoginInfo(user.getUserId());

        return user;
    }


    /**
     * 记录登录信息
     *
     * @param userId 用户ID
     */
    public void recordLoginInfo(Long userId) {
        SysUser user = new SysUser();
        user.setUserId(userId);
        userService.updateUserInfo(user);
    }
}
