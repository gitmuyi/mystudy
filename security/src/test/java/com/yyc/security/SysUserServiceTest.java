package com.yyc.security;

import com.yyc.security.entity.SysRole;
import com.yyc.security.entity.SysUser;
import com.yyc.security.business.SysRoleBusiness;
import com.yyc.security.business.SysUserBusiness;
import com.yyc.common.constant.ConstantKey;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
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
    private SysUserBusiness sysUserService;
    private SysUser sysUser;
    @Autowired
    private SysRoleBusiness sysRoleService;

    @Before
    public void before() {
        sysUser = new SysUser();
        sysUser.setCreateTime(new Date());
        sysUser.setCreateUser("我是创建人");
        sysUser.setPassword("123456");
        sysUser.setUserName("杨永翠5");
        sysUser.setName("测试name");
      //  sysUser.setDeleteFlag((short) 0);
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
        boolean a = bCryptPasswordEncoder.matches("123456", "$2a$10$Cxbc6VjNi2naIIRYDXmvw.tV6AniZ5Jv1dxFf86RGtFQiTwwdW0BC");
        System.out.println(a);
        //System.out.println(encode);
        //$2a$10$z9c2s9zL/sVQG/SJU1d3UeVXl/fw3uQDsNx0Ql2zElV3xcYs3YSEi
    }

    @Test
    public void jwtParase() {
 /*       String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMzU1MzAwODY0Mi1bcm9sZV9hZG1pbl0iLCJleHAiOjE1MzQ3NTYwMzd9.c6POBwwtpNB8qddXwXe3tzwxMWr9igD8YARPzpj4CwsRX6GM-xohK2wFiOcCCg-NpTPxONcBmPikc1AW79wLLg";

        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(ConstantKey.SIGNING_KEY)
                .parseClaimsJws(token);
        System.out.println(claimsJws.getBody());
        System.out.println(claimsJws.getHeader());*/
    }
}
