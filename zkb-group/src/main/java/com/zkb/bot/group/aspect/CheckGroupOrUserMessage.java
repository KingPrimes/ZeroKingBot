package com.zkb.bot.group.aspect;

import com.mikuac.shiro.dto.event.message.AnyMessageEvent;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.mikuac.shiro.dto.event.message.PrivateMessageEvent;
import com.zkb.bot.utils.CheckUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckGroupOrUserMessage {

    private boolean filterTencentBot(long userId) {
        return 2854196300L <= userId && 2854216399L >= userId;
    }

    @Around("execution(* com.zkb.bot.plugin.*.*.*Handler(..))")
    public final Object handler(ProceedingJoinPoint pjp) throws Throwable {
        for (Object arg : pjp.getArgs()) {

            if (arg instanceof AnyMessageEvent) {
                return check(((AnyMessageEvent) arg).getUserId(), ((AnyMessageEvent) arg).getGroupId()) ? pjp.proceed() : 0;
            }

            if (arg instanceof PrivateMessageEvent) {
                return check(((PrivateMessageEvent) arg).getUserId(), 0L) ? pjp.proceed() : 0;
            }

            if (arg instanceof GroupMessageEvent) {
                return check(((GroupMessageEvent) arg).getUserId(), ((GroupMessageEvent) arg).getGroupId()) ? pjp.proceed() : 0;
            }

        }
        return 0;
    }

    private boolean check(long userId, long groupId) {

        if (filterTencentBot(userId)) return false;

        if (CheckUtils.checkUserBlackList(userId)) return false;

        if (CheckUtils.checkGroupBlackList(groupId)) return false;

        return true;
    }

}
