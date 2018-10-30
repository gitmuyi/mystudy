package com.yyc.shiro.service;

import com.yyc.shiro.pojo.SysUser;
import com.yyc.shiro.pojo.SysUserExample;
import com.yyc.shiro.pojo.SysUserKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserService {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(SysUserKey key);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(SysUserKey key);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}