package com.zkb.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 定时任务多线程
 * 线程池配置类
 */
@EnableAsync
@Configuration
public class TaskPoolConfig {

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //线程核心数
        executor.setCorePoolSize(10);
        //最大线程数
        executor.setMaxPoolSize(20);
        //缓冲队列
        executor.setQueueCapacity(200);
        //线程池名称前缀
        executor.setThreadNamePrefix("taskExecutor-");
        //拒绝执行策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        return executor;
    }

}
