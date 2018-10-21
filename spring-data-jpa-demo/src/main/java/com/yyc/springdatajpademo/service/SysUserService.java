package com.yyc.springdatajpademo.service;

import com.yyc.springdatajpademo.entity.SysUser;

import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/17: 17:12
 * @Description:
 */
public interface SysUserService {
    List<SysUser> findByUserName(String userName);
}
