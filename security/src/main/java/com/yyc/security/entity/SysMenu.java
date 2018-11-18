package com.yyc.security.entity;

import java.io.Serializable;

public class SysMenu implements Serializable {
    private String id;

    private Short deleteFlag;

    private String menuSrc;

    private String menuParmentId;

    private String menuIndex;

    private String menuMark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getMenuSrc() {
        return menuSrc;
    }

    public void setMenuSrc(String menuSrc) {
        this.menuSrc = menuSrc;
    }

    public String getMenuParmentId() {
        return menuParmentId;
    }

    public void setMenuParmentId(String menuParmentId) {
        this.menuParmentId = menuParmentId;
    }

    public String getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(String menuIndex) {
        this.menuIndex = menuIndex;
    }

    public String getMenuMark() {
        return menuMark;
    }

    public void setMenuMark(String menuMark) {
        this.menuMark = menuMark;
    }
}