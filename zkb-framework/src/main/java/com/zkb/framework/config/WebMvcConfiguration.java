package com.zkb.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/");
        registry.addResourceHandler("/**")
                .addResourceLocations("file:"+"./ZKBotHtml/");
        registry.addResourceHandler("/relics/**")
                .addResourceLocations("file:"+"./ZKBotHtml/");
        registry.addResourceHandler("/market/**")
                .addResourceLocations("file:"+"./ZKBotHtml/");

    }
}
