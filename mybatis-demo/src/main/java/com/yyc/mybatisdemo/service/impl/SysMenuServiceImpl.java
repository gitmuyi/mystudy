package com.yyc.mybatisdemo.service.impl;


import com.yyc.mybatisdemo.dao.SysMenuMapper;
import com.yyc.mybatisdemo.entity.SysMenu;
import com.yyc.mybatisdemo.entity.SysMenuExample;
import com.yyc.mybatisdemo.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2018/7/23: 08:20
 * @Description:
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public long countByExample(SysMenuExample example) {
        return sysMenuMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysMenuExample example) {
        return sysMenuMapper.deleteByExample(example);
    }

    @Override
    public int insert(SysMenu record) {
        return sysMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(SysMenu record) {
        return sysMenuMapper.insertSelective(record);
    }

    @Override
    public List<SysMenu> selectByExample(SysMenuExample example) {
        return sysMenuMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(SysMenu record, SysMenuExample example) {
        return sysMenuMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysMenu record, SysMenuExample example) {
        return sysMenuMapper.updateByExample(record, example);
    }

    @Override
    public List<SysMenu> findByRoleId(String roleId) {
        return sysMenuMapper.findByRoleId(roleId);
    }
}
