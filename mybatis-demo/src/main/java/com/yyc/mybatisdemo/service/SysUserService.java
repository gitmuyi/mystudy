package com.yyc.mybatisdemo.service;


import com.yyc.mybatisdemo.entity.SysUserExample;
import com.yyc.mybatisdemo.entity.SysUser;

import java.util.List;

public interface SysUserService {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(String id);

    int updateByExampleSelective(SysUser record, SysUserExample example);

    int updateByExample(SysUser record, SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectUserAndDept(String id);
    SysUser selectUserAndDeptStep(String id);
    String selectMaxUserName();
}