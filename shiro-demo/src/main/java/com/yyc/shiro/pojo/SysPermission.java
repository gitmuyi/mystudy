package com.yyc.shiro.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class SysPermission {
    private Integer id;

    private String name;

    private String description;

    private String url;

    private String perms;

    private Integer parentId;

    private Integer type;

    private Integer orderNum;

    private String icon;

    private Integer status;

    private Date createTime;

    private Date updateTime;

}