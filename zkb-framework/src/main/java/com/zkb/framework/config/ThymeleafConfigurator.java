package com.zkb.framework.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;


@Configuration
public class ThymeleafConfigurator {

    //设置多个Template配置
    @Bean
    public SpringResourceTemplateResolver iSpringTemplateResolver() {
        SpringResourceTemplateResolver srt = new SpringResourceTemplateResolver();
        srt.setPrefix("file:./ZKBotHtml/");
        srt.setSuffix(".html");
        srt.setTemplateMode(TemplateMode.HTML);
        srt.setCharacterEncoding("UTF-8");
        srt.setOrder(1);
        srt.setCacheable(false);
        srt.setCheckExistence(true);
        return srt;
    }
}
