package com.twg.bot.aiml.utils;

import java.util.Random;

/**
 * @author KingPrimes
 */
public class OtherUtils {

    /**
     * 根据输入值 概率返回是否执行
     *
     * @param g 0 - 100
     * @return true or false
     */
    public static boolean random(int g) {
        Random r = new Random();
        int i = r.nextInt(100);
        boolean m;
        m = i < g;
        return m;
    }
}
