package com.yyc.security.entity;

import lombok.Data;

@Data
public class SysRoleMenu {
    private String id;

    private String roleId;

    private String menuId;

    private Short deleteFlag;

    public String getId() {
        return id;
    }


}