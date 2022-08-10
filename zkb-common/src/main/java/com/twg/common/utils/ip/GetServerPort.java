package com.twg.common.utils.ip;


import com.twg.common.utils.spring.SpringUtils;
import org.springframework.core.env.Environment;

public class GetServerPort {
    public static String getPort() {
        return SpringUtils.getBean(Environment.class).getProperty("local.server.port");
    }
}
