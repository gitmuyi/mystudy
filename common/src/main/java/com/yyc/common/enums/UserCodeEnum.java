package com.yyc.common.enums;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/23: 14:10
 * @Description:
 */
public enum UserCodeEnum {

    EXISTED("1001", "用户已经存在"),

    UNEXISTED("2001", "用户不存在");


    private String code;
    private String name;

    UserCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
