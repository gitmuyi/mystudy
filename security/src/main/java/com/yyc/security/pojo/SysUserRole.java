package com.yyc.security.pojo;

import lombok.Data;

@Data
public class SysUserRole {
    private String id;

    private String userId;

    private String roleId;

    private Short deleteFlag;

}