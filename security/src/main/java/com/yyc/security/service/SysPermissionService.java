package com.yyc.security.service;


import com.yyc.security.entity.SysPermission;
import com.yyc.security.entity.SysPermissionExample;

import java.util.List;

public interface SysPermissionService {
    long countByExample(SysPermissionExample example);

    int deleteByExample(SysPermissionExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExample(SysPermissionExample example);

    SysPermission selectByPrimaryKey(String id);

    int updateByExampleSelective(SysPermission record, SysPermissionExample example);

    int updateByExample(SysPermission record, SysPermissionExample example);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}