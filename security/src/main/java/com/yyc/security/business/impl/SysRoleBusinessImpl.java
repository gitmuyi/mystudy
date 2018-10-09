package com.yyc.security.business.impl;

import com.yyc.security.entity.SysRole;
import com.yyc.security.entity.SysRoleExample;

import com.yyc.security.service.SysRoleService;
import com.yyc.security.business.SysRoleBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2sysRoleService18/7/23: sysRoleService8:22
 * @Description:
 */
@Service
public class SysRoleBusinessImpl implements SysRoleBusiness {
    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public long countByExample(SysRoleExample example) {
        return sysRoleService.countByExample(example);
    }

    @Override
    public int deleteByExample(SysRoleExample example) {
        return sysRoleService.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return sysRoleService.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRole record) {
        return sysRoleService.insert(record);
    }

    @Override
    public int insertSelective(SysRole record) {
        return sysRoleService.insertSelective(record);
    }

    @Override
    public List<SysRole> selectByExample(SysRoleExample example) {
        return sysRoleService.selectByExample(example);
    }

    @Override
    public SysRole selectByPrimaryKey(String id) {
        return sysRoleService.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(SysRole record, SysRoleExample example) {
        return sysRoleService.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysRole record, SysRoleExample example) {
        return sysRoleService.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRole record) {
        return sysRoleService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRole record) {
        return sysRoleService.updateByPrimaryKey(record);
    }

    @Override
    public List<SysRole> findRoleByUserId(String userId) {
        return sysRoleService.findRoleByUserId(userId);
    }
}
