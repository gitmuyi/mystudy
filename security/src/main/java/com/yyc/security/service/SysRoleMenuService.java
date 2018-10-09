package com.yyc.security.service;



import com.yyc.security.entity.SysRoleMenu;
import com.yyc.security.entity.SysRoleMenuExample;

import java.util.List;

public interface SysRoleMenuService {
    long countByExample(SysRoleMenuExample example);

    int deleteByExample(SysRoleMenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    List<SysRoleMenu> selectByExample(SysRoleMenuExample example);

    SysRoleMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(SysRoleMenu record, SysRoleMenuExample example);

    int updateByExample(SysRoleMenu record, SysRoleMenuExample example);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);
}