package com.yyc.security.dao;

import com.yyc.security.entity.SysUserRole;
import com.yyc.security.entity.SysUserRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysUserRoleMapper {
    long countByExample(SysUserRoleExample example);

    int deleteByExample(SysUserRoleExample example);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    List<SysUserRole> selectByExample(SysUserRoleExample example);

    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);
}