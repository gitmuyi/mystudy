package com.yyc.shiro.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class SysRole {
    private Integer id;

    private String name;

    private String description;

    private Integer status;

    private Date createTime;

    private Date updateTime;
}