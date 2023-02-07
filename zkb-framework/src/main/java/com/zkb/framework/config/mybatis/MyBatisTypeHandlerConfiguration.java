package com.zkb.framework.config.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({SqlSessionFactory.class})
public class MyBatisTypeHandlerConfiguration {
    private TypeHandlerRegistry typeHandlerRegistry;


    public MyBatisTypeHandlerConfiguration(SqlSessionFactory sqlSessionFactory) {
        this.typeHandlerRegistry = sqlSessionFactory.getConfiguration().getTypeHandlerRegistry();

    }

    /**
     * 注册 枚举 类型的类型转换器
     *
     * @param javaTypeClass Java 类型
     */
    private void registerEnumTypeHandler(Class<?> javaTypeClass) {
        register(javaTypeClass, EnumTypeHandler.class);
    }

    /**
     * 注册类型转换器
     *
     * @param javaTypeClass    Java 类型
     * @param typeHandlerClass 类型转换器类型
     */
    private void register(Class<?> javaTypeClass, Class<?> typeHandlerClass) {
        this.typeHandlerRegistry.register(javaTypeClass, typeHandlerClass);
    }



}
