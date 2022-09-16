package com.zkb.framework.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
 @Resource
    private DataSourceProperties dataSourceProperties;

    @Bean
    @Primary
    public DataSource dataSource() {

        return DataSourceBuilder.create()
                .driverClassName("org.sqlite.JDBC")
                .url(dataSourceProperties.getUrl())
                .type(SqliteUdfDataSource.class)
                .build();

    }


}
