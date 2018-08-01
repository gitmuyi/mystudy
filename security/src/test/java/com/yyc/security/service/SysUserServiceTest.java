package com.yyc.security.service;

import com.yyc.security.pojo.SysRole;
import com.yyc.security.pojo.SysUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

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
    @Autowired
    private SysRoleService sysRoleService;

    @Before
    public void before() {
        sysUser = new SysUser();
        sysUser.setCreateTime(new Date());
        sysUser.setCreateUser("我是创建人");
        sysUser.setPassword("123456");
        sysUser.setUserName("杨永翠5");
        sysUser.setName("测试name");
        sysUser.setDeleteFlag((short) 0);
    }

    @Test
    public void testInsert() {
        System.out.println(sysUser);
        //sysUserService.insert(sysUser);
        // System.out.println(sysUser.getId());
        //  sysUserService.insertSelective(sysUser);
        // System.out.println(sysUser.getId());
        List<SysRole> roleByUserId = sysRoleService.findRoleByUserId("95");
        System.out.println(roleByUserId);

    }

    @Test
    public void testPassWord() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
       // String encode = bCryptPasswordEncoder.encode("123456");
      boolean a=  bCryptPasswordEncoder.matches("123456","$2a$10$Cxbc6VjNi2naIIRYDXmvw.tV6AniZ5Jv1dxFf86RGtFQiTwwdW0BC");
        System.out.println(a);
      //System.out.println(encode);
        //$2a$10$z9c2s9zL/sVQG/SJU1d3UeVXl/fw3uQDsNx0Ql2zElV3xcYs3YSEi
    }

}
