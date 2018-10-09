package com.yyc.security.business;

import com.yyc.security.entity.SysUserRole;
import com.yyc.security.entity.SysUserRoleExample;

import java.util.List;

public interface SysUserRoleBusiness {
    long countByExample(SysUserRoleExample example);

    int deleteByExample(SysUserRoleExample example);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    List<SysUserRole> selectByExample(SysUserRoleExample example);

    int updateByExampleSelective( SysUserRole record,SysUserRoleExample example);

    int updateByExample( SysUserRole record,  SysUserRoleExample example);
}