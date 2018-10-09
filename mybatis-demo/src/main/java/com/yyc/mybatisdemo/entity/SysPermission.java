package com.yyc.mybatisdemo.entity;

import lombok.Data;

@Data
public class SysPermission {
    private String id;

    private Short deleteFlag;

    private String permName;

    private String permCode;

    public String getId() {
        return id;
    }


}