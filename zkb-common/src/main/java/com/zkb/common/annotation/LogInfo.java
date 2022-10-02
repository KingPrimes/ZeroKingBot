package com.zkb.common.annotation;

import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.TitleType;

import java.lang.annotation.*;

/**
 * 自定义日志记录注解
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogInfo {
    /**
     * 模块
     */
    TitleType title() default TitleType.O;

    /**
     * 执行的命令
     */
    String orderType() default "";

    /**
     * 功能
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 请求得群组
     */
    long group() default 0;

    /**
     * 请求得人员
     */
    long user() default 0;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    public boolean isSaveResponseData() default true;
}
