package com.yyc.mybatisdemo.entity;

import lombok.Data;
import sun.rmi.log.LogInputStream;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2019/4/23: 17:28
 * @Description:
 */
@Data
public class SysDept implements Serializable {
    private static final long serialVersionUID = -2187965756595256486L;
    private String id;

    private String deptName;

    private List<SysUser> sysUsers;

}
