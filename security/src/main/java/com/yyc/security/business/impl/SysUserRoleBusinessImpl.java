package com.yyc.security.business.impl;

import com.yyc.security.entity.SysUserRole;
import com.yyc.security.service.SysUserRoleService;
import com.yyc.security.entity.SysUserRoleExample;
import com.yyc.security.business.SysUserRoleBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2sysUserRoleService18/7/23: sysUserRoleService8:22
 * @Description:
 */
@Service
public class SysUserRoleBusinessImpl implements SysUserRoleBusiness {
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public long countByExample(SysUserRoleExample example) {
        return sysUserRoleService.countByExample(example);
    }

    @Override
    public int deleteByExample(SysUserRoleExample example) {
        return sysUserRoleService.deleteByExample(example);
    }

    @Override
    public int insert(SysUserRole record) {
        return sysUserRoleService.insert(record);
    }

    @Override
    public int insertSelective(SysUserRole record) {
        return sysUserRoleService.insertSelective(record);
    }

    @Override
    public List<SysUserRole> selectByExample(SysUserRoleExample example) {
        return sysUserRoleService.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(SysUserRole record, SysUserRoleExample example) {
        return sysUserRoleService.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysUserRole record, SysUserRoleExample example) {
        return sysUserRoleService.updateByExample(record, example);
    }
}
