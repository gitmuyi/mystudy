package com.yyc.springdatajpademo.service.impl;

import com.yyc.springdatajpademo.dao.SysUserDao;
import com.yyc.springdatajpademo.entity.SysUser;
import com.yyc.springdatajpademo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/17: 17:15
 * @Description:
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public List<SysUser> findByUserName(String userName) {
        return sysUserDao.findByUserName(userName);
    }
}
