package com.yyc.shiro.service.impl;

import com.yyc.shiro.dao.SysRolePermissionMapper;
import com.yyc.shiro.pojo.SysRolePermission;
import com.yyc.shiro.pojo.SysRolePermissionExample;
import com.yyc.shiro.service.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2sysRolePermissionMapper18/1sysRolePermissionMapper/29: 13:22
 * @Description:
 */
@Service
@Transactional
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public long countByExample(SysRolePermissionExample example) {
        return sysRolePermissionMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysRolePermissionExample example) {
        return sysRolePermissionMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysRolePermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRolePermission record) {
        return sysRolePermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRolePermission record) {
        return sysRolePermissionMapper.insertSelective(record);
    }

    @Override
    public List<SysRolePermission> selectByExample(SysRolePermissionExample example) {
        return sysRolePermissionMapper.selectByExample(example);
    }

    @Override
    public SysRolePermission selectByPrimaryKey(Integer id) {
        return sysRolePermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(SysRolePermission record, SysRolePermissionExample example) {
        return sysRolePermissionMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysRolePermission record, SysRolePermissionExample example) {
        return sysRolePermissionMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRolePermission record) {
        return sysRolePermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRolePermission record) {
        return sysRolePermissionMapper.updateByPrimaryKey(record);
    }
}
