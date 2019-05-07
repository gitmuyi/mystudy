package com.yyc.mybatisdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonIgnoreProperties(value = {"handler"})
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

    private String deptId;

    private SysDept sysDept;
}