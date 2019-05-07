package com.yyc.mybatisdemo.dao;

import com.yyc.mybatisdemo.entity.SysDept;
import com.yyc.mybatisdemo.entity.SysUser;
import com.yyc.mybatisdemo.entity.SysUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysDeptMapper {
    SysDept selectById(String id);

    SysDept selectByIdStep(String id);

    SysDept selectDeptAndUserByDeptId(String deptId);

}