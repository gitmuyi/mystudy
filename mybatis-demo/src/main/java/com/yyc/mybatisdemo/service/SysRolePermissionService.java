package com.yyc.mybatisdemo.service;



import com.yyc.mybatisdemo.entity.SysRolePermission;
import com.yyc.mybatisdemo.entity.SysRolePermissionExample;

import java.util.List;

public interface SysRolePermissionService {
    long countByExample(SysRolePermissionExample example);

    int deleteByExample(SysRolePermissionExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    List<SysRolePermission> selectByExample(SysRolePermissionExample example);

    SysRolePermission selectByPrimaryKey(String id);

    int updateByExampleSelective(SysRolePermission record, SysRolePermissionExample example);

    int updateByExample(SysRolePermission record, SysRolePermissionExample example);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}