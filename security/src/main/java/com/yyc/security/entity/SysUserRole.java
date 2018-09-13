package com.yyc.security.entity;

import lombok.Data;

@Data
public class SysUserRole {
    private String id;

    private String userId;

    private String roleId;

    private Short deleteFlag;

}