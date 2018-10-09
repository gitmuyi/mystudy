package com.yyc.security.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = -2349098286290633740L;
    private String id;

    private String userName;

    private String password;

    private String name;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private String deleteFlag;
}