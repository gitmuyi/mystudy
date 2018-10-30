package com.yyc.shiro;

import com.yyc.shiro.dao.SysRoleMapper;
import com.yyc.shiro.pojo.SysRole;
import com.yyc.shiro.pojo.SysRoleExample;
import com.yyc.shiro.pojo.SysUser;
import com.yyc.shiro.pojo.SysUserExample;
import com.yyc.shiro.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroDemoApplicationTests {
    @Autowired
    private SysUserService sysUserService;

    @Test
    public void contextLoads() {
        List<SysUser> sysUsers = sysUserService.selectByExample(new SysUserExample());
        System.out.println(sysUsers);
    }

}
