package com.yyc.mybatisdemo.entity;

import lombok.Data;

@Data
public class SysMenu {
    private String id;

    private Short deleteFlag;

    private String menuSrc;

    private String menuParmentId;

    private String menuIndex;

    private String menuMark;

    public String getId() {
        return id;
    }


}