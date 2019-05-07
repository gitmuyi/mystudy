package com.yyc.mybatisdemo.dao;

import com.yyc.mybatisdemo.entity.SysUserExample;
import com.yyc.mybatisdemo.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SysUserMapper {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 查询用户部门信息
     *
     * @param id
     * @return
     */
    SysUser selectUserAndDept(String id);

    /**
     * 分步查询
     *
     * @param id
     * @return
     */
    SysUser selectUserAndDeptStep(String id);

    /**
     * 通过 部门id查询用户信息
     *
     * @param deptId
     * @return
     */
    List<SysUser> getUserByDeptId(String deptId);

    String selectMaxUserName();

}