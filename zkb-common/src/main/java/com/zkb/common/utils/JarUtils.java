package com.zkb.common.utils;

import java.util.Objects;

public class JarUtils {

    /**
     * 判断启动模式
     * @param clazz 类文件
     * @return true Jar包启动
     */
    public static <T> boolean isStartupFromJarEx(Class<T> clazz) {
        String protocol = Objects.requireNonNull(clazz.getResource("")).getProtocol();
        if (Objects.equals(protocol, "jar")) {
            return true;
        } else return !Objects.equals(protocol, "file");
    }
}
