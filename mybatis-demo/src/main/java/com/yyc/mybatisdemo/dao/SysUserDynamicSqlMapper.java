package com.yyc.mybatisdemo.dao;

import com.yyc.mybatisdemo.entity.SysUser;

import java.util.List;

public interface SysUserDynamicSqlMapper {
    SysUser selectUserById(String id);

    List<SysUser> selectSysUserWithIf(SysUser sysUser);
}
