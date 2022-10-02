package com.zkb.common.enums;

/**
 * 操作人类别
 * 
 * @author KingPrimes
 */
public enum OperatorType
{
    /**
     * 其它
     */
    OTHER("其它"),

    /**
     * 后台用户
     */
    MANAGE("后台用户"),

    /**
     * 手机端用户
     */
    MOBILE("手机用户");
    final String type;
     OperatorType(String type){
        this.type = type;
    }
    public String getType(){
         return type;
    }
}
