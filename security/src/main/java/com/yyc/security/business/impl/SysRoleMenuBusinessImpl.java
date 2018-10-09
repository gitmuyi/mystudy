package com.yyc.security.business.impl;


import com.yyc.security.entity.SysRoleMenu;
import com.yyc.security.entity.SysRoleMenuExample;
import com.yyc.security.service.SysRoleMenuService;
import com.yyc.security.business.SysRoleMenuBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2018/7/23: 08:21
 * @Description:
 */
@Service
public class SysRoleMenuBusinessImpl implements SysRoleMenuBusiness {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @Override
    public long countByExample(SysRoleMenuExample example) {
        return sysRoleMenuService.countByExample(example);
    }

    @Override
    public int deleteByExample(SysRoleMenuExample example) {
        return sysRoleMenuService.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return sysRoleMenuService.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRoleMenu record) {
        return sysRoleMenuService.insert(record);
    }

    @Override
    public int insertSelective(SysRoleMenu record) {
        return sysRoleMenuService.insertSelective(record);
    }

    @Override
    public List<SysRoleMenu> selectByExample(SysRoleMenuExample example) {
        return sysRoleMenuService.selectByExample(example);
    }

    @Override
    public SysRoleMenu selectByPrimaryKey(String id) {
        return sysRoleMenuService.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(SysRoleMenu record, SysRoleMenuExample example) {
        return sysRoleMenuService.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(SysRoleMenu record, SysRoleMenuExample example) {
        return sysRoleMenuService.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRoleMenu record) {
        return sysRoleMenuService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRoleMenu record) {
        return sysRoleMenuService.updateByPrimaryKey(record);
    }
}
