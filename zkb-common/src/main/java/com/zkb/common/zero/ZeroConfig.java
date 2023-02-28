package com.zkb.common.zero;

import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ZeroConfig {

    @Value("${zero.isTest}")
    Boolean isTest;

    public static Boolean getTest() {
        return SpringUtils.getBean(ZeroConfig.class).isTest;
    }
}
