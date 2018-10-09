package com.yyc.mybatisdemo.service;



import com.yyc.mybatisdemo.entity.SysMenu;
import com.yyc.mybatisdemo.entity.SysMenuExample;

import java.util.List;

public interface SysMenuService {
    long countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    int updateByExampleSelective(SysMenu record, SysMenuExample example);

    int updateByExample(SysMenu record, SysMenuExample example);

    List<SysMenu> findByRoleId(String roleId);
}