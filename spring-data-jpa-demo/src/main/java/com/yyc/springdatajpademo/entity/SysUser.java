package com.yyc.springdatajpademo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class SysUser implements Serializable {
    private static final long serialVersionUID = -2349098286290633740L;
    @GeneratedValue
    @Id
    private String id;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private Date createTime;
    @Column
    private String createUser;
    @Column
    private Date updateTime;
    @Column
    private String updateUser;
    @Column
    private String deleteFlag;
}