package com.yyc.mybatisdemo.service;



import com.yyc.mybatisdemo.entity.SysRoleMenuExample;
import com.yyc.mybatisdemo.entity.SysRoleMenu;

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