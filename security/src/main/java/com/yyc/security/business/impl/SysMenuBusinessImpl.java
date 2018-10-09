package com.yyc.security.business.impl;


import com.yyc.security.entity.SysMenu;
import com.yyc.security.entity.SysMenuExample;
import com.yyc.security.service.SysMenuService;
import com.yyc.security.business.SysMenuBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2018/7/23: 08:20
 * @Description:
 */
@Service
public class SysMenuBusinessImpl implements SysMenuBusiness {
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public long countByExample(SysMenuExample example) {
        return sysMenuService.countByExample(example);
    }

    @Override
    public int deleteByExample(SysMenuExample example) {
        return sysMenuService.deleteByExample(example);
    }

    @Override
    public int insert(SysMenu record) {
        return sysMenuService.insert(record);
    }

    @Override
    public int insertSelective(SysMenu record) {
        return sysMenuService.insertSelective(record);
    }

    @Override
    public List<SysMenu> selectByExample(SysMenuExample example) {
        return sysMenuService.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(SysMenu record, SysMenuExample example) {
        return sysMenuService.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysMenu record, SysMenuExample example) {
        return sysMenuService.updateByExample(record, example);
    }

    @Override
    public List<SysMenu> findByRoleId(String roleId) {
        return sysMenuService.findByRoleId(roleId);
    }
}
