package com.zkb.framework.config;

import com.zkb.common.utils.MessageUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class LocaleConfig {
   /* @Bean
    public MessageUtils messageUtils() {
        return new MessageUtils(messageSource());
    }

    *//**
     *资源文件路径
     **//*
    @Bean
    public ResourceBundleMessageSource messageSource() {
        Locale.setDefault(Locale.CHINESE);
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        *//*ame of the resource bundle*//*
        source.setBasenames("i18n/messages");
        //默认是false，调试设置为true
        source.setUseCodeAsDefaultMessage(true);
        source.setDefaultEncoding("UTF-8");
        return source;
    }


    *//**
     * 默认解析器 其中locale表示默认语言
     *//*
    @Bean
    public LocaleResolver localeResolver() {
        // localeResolver.setDefaultLocale(Locale.UK);
        return new SessionLocaleResolver();
    }*/
}
