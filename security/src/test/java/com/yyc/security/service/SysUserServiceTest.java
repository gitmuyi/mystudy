package com.yyc.security.service;

import com.yyc.security.pojo.SysUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Auther: yangyongcui
 * @Date: 2018/7/23: 09:00
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysUserServiceTest {
    @Autowired
    private SysUserService sysUserService;
    private SysUser sysUser;

    @Before
    public void before() {
        sysUser = new SysUser();
        sysUser.setCreateTime(new Date());
        sysUser.setCreateUser("我是创建人");
        sysUser.setPassword("123456");
        sysUser.setUserName("杨永翠");
        sysUser.setDeleteFlag((short) 0);
    }

    @Test
    public void testInsert() {
        sysUserService.insert(sysUser);
        System.out.println(sysUser.getId());
        sysUserService.insertSelective(sysUser);
        System.out.println(sysUser.getId());
    }
}
