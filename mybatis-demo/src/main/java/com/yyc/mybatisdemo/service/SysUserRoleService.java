package com.yyc.mybatisdemo.service;



import com.yyc.mybatisdemo.entity.SysUserRole;
import com.yyc.mybatisdemo.entity.SysUserRoleExample;

import java.util.List;

public interface SysUserRoleService {
    long countByExample(SysUserRoleExample example);

    int deleteByExample(SysUserRoleExample example);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    List<SysUserRole> selectByExample(SysUserRoleExample example);

    int updateByExampleSelective(SysUserRole record, SysUserRoleExample example);

    int updateByExample(SysUserRole record, SysUserRoleExample example);
}