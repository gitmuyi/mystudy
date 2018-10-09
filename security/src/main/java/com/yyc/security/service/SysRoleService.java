package com.yyc.security.service;


import com.yyc.security.entity.SysRole;
import com.yyc.security.entity.SysRoleExample;

import java.util.List;

public interface SysRoleService {
    long countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(String id);

    int updateByExampleSelective(SysRole record, SysRoleExample example);

    int updateByExample(SysRole record, SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> findRoleByUserId(String userId);
}