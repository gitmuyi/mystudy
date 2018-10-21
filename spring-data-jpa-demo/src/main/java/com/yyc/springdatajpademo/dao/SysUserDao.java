package com.yyc.springdatajpademo.dao;

import com.yyc.springdatajpademo.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/17: 17:10
 * @Description:
 */
public interface SysUserDao extends JpaRepository<SysUser, String> {
    List<SysUser> findByUserName(String userName);
}
