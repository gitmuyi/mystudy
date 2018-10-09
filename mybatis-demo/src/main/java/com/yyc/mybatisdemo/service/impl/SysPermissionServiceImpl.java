package com.yyc.mybatisdemo.service.impl;


import com.yyc.mybatisdemo.dao.SysPermissionMapper;
import com.yyc.mybatisdemo.entity.SysPermission;
import com.yyc.mybatisdemo.entity.SysPermissionExample;
import com.yyc.mybatisdemo.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2018/7/23: 08:20
 * @Description:
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public long countByExample(SysPermissionExample example) {
        return sysPermissionMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysPermissionExample example) {
        return sysPermissionMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return sysPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysPermission record) {
        return sysPermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(SysPermission record) {
        return sysPermissionMapper.insertSelective(record);
    }

    @Override
    public List<SysPermission> selectByExample(SysPermissionExample example) {
        return sysPermissionMapper.selectByExample(example);
    }

    @Override
    public SysPermission selectByPrimaryKey(String id) {
        return sysPermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(SysPermission record, SysPermissionExample example) {
        return sysPermissionMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysPermission record, SysPermissionExample example) {
        return sysPermissionMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysPermission record) {
        return sysPermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysPermission record) {
        return sysPermissionMapper.updateByPrimaryKey(record);
    }
}
