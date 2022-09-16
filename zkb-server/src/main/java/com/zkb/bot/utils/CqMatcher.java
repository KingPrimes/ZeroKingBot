package com.zkb.bot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CqMatcher {

    /**
     * 判断是否CQ表情码
     * @param str 字符串
     * @return true/false
     */
    public static boolean isCqFace(String str){
        return isStr(str,"CQ:face,id=[0-9]+");
    }

    /**
     * 判断是否CQ Image
     * @param str 字符串
     * @return true/false
     */
    public static boolean isCqImage(String str){
        return isStr(str,"CQ:image,(.*?)url=(.*?)?term=3");
    }

    /**
     * 判断是否携带@
     * @param str 字符串
     * @return true/false
     */
    public static boolean isCqAt(String str){
        return isStr(str,"CQ:at,qq=[1-9][0-9]{4,}");
    }



    private static boolean isStr(String str,String regex){
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.find();
    }

}
