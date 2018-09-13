package com.yyc.security.service.impl;

import com.yyc.security.dao.SysRoleMenuMapper;
import com.yyc.security.entity.SysRoleMenu;
import com.yyc.security.entity.SysRoleMenuExample;
import com.yyc.security.service.SysRoleMenuService;
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
