package com.yyc.security.common.enums;

public enum DeleteEnum {
    UNDELETE((short) 0, "正常"),
    DELETE((short) 1, "已删除");
    private short name;
    private String value;

    DeleteEnum(short name, String value) {
        this.name = name;
        this.value = value;
    }

    public short getName() {
        return this.name;
    }
}
