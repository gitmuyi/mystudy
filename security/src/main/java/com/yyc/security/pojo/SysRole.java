package com.yyc.security.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SysRole {
    private String id;

    private String roleName;

    private String role;
    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private Short deleteFlag;


}