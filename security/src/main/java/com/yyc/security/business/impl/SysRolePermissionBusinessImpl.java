package com.yyc.security.business.impl;


import com.yyc.security.entity.SysRolePermission;
import com.yyc.security.entity.SysRolePermissionExample;
import com.yyc.security.service.SysRolePermissionService;
import com.yyc.security.business.SysRolePermissionBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2sysRolePermissionService18/7/23: sysRolePermissionService8:21
 * @Description:
 */
@Service
public class SysRolePermissionBusinessImpl implements SysRolePermissionBusiness {
    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    @Override
    public long countByExample(SysRolePermissionExample example) {
        return sysRolePermissionService.countByExample(example);
    }

    @Override
    public int deleteByExample(SysRolePermissionExample example) {
        return sysRolePermissionService.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return sysRolePermissionService.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRolePermission record) {
        return sysRolePermissionService.insert(record);
    }

    @Override
    public int insertSelective(SysRolePermission record) {
        return sysRolePermissionService.insertSelective(record);
    }

    @Override
    public List<SysRolePermission> selectByExample(SysRolePermissionExample example) {
        return sysRolePermissionService.selectByExample(example);
    }

    @Override
    public SysRolePermission selectByPrimaryKey(String id) {
        return sysRolePermissionService.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(SysRolePermission record, SysRolePermissionExample example) {
        return sysRolePermissionService.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysRolePermission record, SysRolePermissionExample example) {
        return sysRolePermissionService.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRolePermission record) {
        return sysRolePermissionService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRolePermission record) {
        return sysRolePermissionService.updateByPrimaryKey(record);
    }
}
