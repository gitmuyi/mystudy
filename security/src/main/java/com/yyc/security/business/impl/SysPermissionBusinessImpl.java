package com.yyc.security.business.impl;


import com.yyc.security.entity.SysPermission;
import com.yyc.security.entity.SysPermissionExample;
import com.yyc.security.service.SysPermissionService;
import com.yyc.security.business.SysPermissionBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2018/7/23: 08:20
 * @Description:
 */
@Service
public class SysPermissionBusinessImpl implements SysPermissionBusiness {
    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    public long countByExample(SysPermissionExample example) {
        return sysPermissionService.countByExample(example);
    }

    @Override
    public int deleteByExample(SysPermissionExample example) {
        return sysPermissionService.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return sysPermissionService.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysPermission record) {
        return sysPermissionService.insert(record);
    }

    @Override
    public int insertSelective(SysPermission record) {
        return sysPermissionService.insertSelective(record);
    }

    @Override
    public List<SysPermission> selectByExample(SysPermissionExample example) {
        return sysPermissionService.selectByExample(example);
    }

    @Override
    public SysPermission selectByPrimaryKey(String id) {
        return sysPermissionService.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(SysPermission record, SysPermissionExample example) {
        return sysPermissionService.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysPermission record, SysPermissionExample example) {
        return sysPermissionService.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysPermission record) {
        return sysPermissionService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysPermission record) {
        return sysPermissionService.updateByPrimaryKey(record);
    }
}
