package com.yyc.security.pojo;

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

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
        this.menuSrc = menuSrc == null ? null : menuSrc.trim();
    }

    public String getMenuParmentId() {
        return menuParmentId;
    }

    public void setMenuParmentId(String menuParmentId) {
        this.menuParmentId = menuParmentId == null ? null : menuParmentId.trim();
    }

    public String getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(String menuIndex) {
        this.menuIndex = menuIndex == null ? null : menuIndex.trim();
    }

    public String getMenuMark() {
        return menuMark;
    }

    public void setMenuMark(String menuMark) {
        this.menuMark = menuMark == null ? null : menuMark.trim();
    }
}