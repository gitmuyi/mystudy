package com.yyc.shiro.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class SysUser extends SysUserKey {
    private static final long serialVersionUID = 3058245326749268792L;
    private String username;

    private String password;

    private String salt;

    private String email;

    private String phone;

    private Integer sex;

    private Integer age;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Date lastLoginTime;

}