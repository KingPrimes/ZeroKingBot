package com.zkb.common.enums;

/**
 * 业务操作类型
 *
 * @author KingPrimes
 */
public enum BusinessType {
    /**
     * 其它
     */
    OTHER("其它"),

    /**
     * 查询
     */
    SELECT("查询"),

    /**
     * 新增
     */
    INSERT("新增"),

    /**
     * 修改
     */
    UPDATE("修改"),

    /**
     * 删除
     */
    DELETE("删除"),

    /**
     * 授权
     */
    GRANT("授权"),

    /**
     * 导出
     */
    EXPORT("导出"),

    /**
     * 导入
     */
    IMPORT("导入"),

    /**
     * 强退
     */
    FORCE("强退"),

    /**
     * 生成代码
     */
    GENCODE("生成代码"),

    /**
     * 清空
     */
    CLEAN("清空"),
    /**
     * 生成图片
     */
    IMAGE("生成图片"),
    ;
    final String type;

    BusinessType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
