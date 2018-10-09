package com.yyc.mybatisdemo.service.impl;

import com.yyc.mybatisdemo.entity.SysRoleMenuExample;
import com.yyc.mybatisdemo.service.SysRoleMenuService;
import com.yyc.mybatisdemo.dao.SysRoleMenuMapper;
import com.yyc.mybatisdemo.entity.SysRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2018/7/23: 08:21
 * @Description:
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public long countByExample(SysRoleMenuExample example) {
        return sysRoleMenuMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysRoleMenuExample example) {
        return sysRoleMenuMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return sysRoleMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRoleMenu record) {
        return sysRoleMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRoleMenu record) {
        return sysRoleMenuMapper.insertSelective(record);
    }

    @Override
    public List<SysRoleMenu> selectByExample(SysRoleMenuExample example) {
        return sysRoleMenuMapper.selectByExample(example);
    }

    @Override
    public SysRoleMenu selectByPrimaryKey(String id) {
        return sysRoleMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(SysRoleMenu record, SysRoleMenuExample example) {
        return sysRoleMenuMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(SysRoleMenu record, SysRoleMenuExample example) {
        return sysRoleMenuMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRoleMenu record) {
        return sysRoleMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRoleMenu record) {
        return sysRoleMenuMapper.updateByPrimaryKey(record);
    }
}
