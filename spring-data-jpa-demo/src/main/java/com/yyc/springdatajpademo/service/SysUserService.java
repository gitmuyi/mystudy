package com.yyc.springdatajpademo.service;

import com.yyc.springdatajpademo.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/17: 17:12
 * @Description:
 */
public interface SysUserService {
    List<SysUser> findByUserName(String userName);

    Page<SysUser> findByCreateTimeBefore(Date createTime, Pageable pageable);


}
