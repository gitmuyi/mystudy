package com.yyc.security.business;



import com.yyc.security.entity.SysMenu;
import com.yyc.security.entity.SysMenuExample;

import java.util.List;

public interface SysMenuBusiness {
    long countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    int updateByExampleSelective( SysMenu record,  SysMenuExample example);

    int updateByExample( SysMenu record,SysMenuExample example);

    List<SysMenu> findByRoleId( String roleId);
}