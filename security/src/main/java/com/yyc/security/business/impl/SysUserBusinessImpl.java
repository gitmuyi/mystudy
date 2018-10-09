package com.yyc.security.business.impl;

import com.yyc.security.entity.SysUserExample;
import com.yyc.security.service.SysUserService;
import com.yyc.security.entity.SysUser;
import com.yyc.security.business.SysUserBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2sysUserService18/7/23: sysUserService8:22
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserBusinessImpl implements SysUserBusiness {
    @Autowired
    private SysUserService sysUserService;

    @Override
    public long countByExample(SysUserExample example) {
        return sysUserService.countByExample(example);
    }

    @Override
    public int deleteByExample(SysUserExample example) {
        return sysUserService.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return sysUserService.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUser record) {
        return sysUserService.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return sysUserService.insertSelective(record);
    }

    @Override
    public List<SysUser> selectByExample(SysUserExample example) {
        return sysUserService.selectByExample(example);
    }

    @Override
    public SysUser selectByPrimaryKey(String id) {
        return sysUserService.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(SysUser record, SysUserExample example) {
        return sysUserService.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysUser record, SysUserExample example) {
        return sysUserService.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return sysUserService.updateByPrimaryKey(record);
    }
}
