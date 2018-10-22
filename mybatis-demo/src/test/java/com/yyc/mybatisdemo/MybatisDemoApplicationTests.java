package com.yyc.mybatisdemo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yyc.mybatisdemo.dao.SysUserMapper;
import com.yyc.mybatisdemo.entity.SysUser;
import com.yyc.mybatisdemo.entity.SysUserExample;
import com.yyc.mybatisdemo.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void testInsert() {

        SysUser sysUser = new SysUser();
        sysUser.setPassword("1112");
        sysUser.setUserName("1562");
        sysUser.setName("1232");
        sysUser.setDeleteFlag("0");
        sysUser.setCreateTime(new Date());
        sysUser.setCreateUser("cc");
        int i = sysUserService.insert(sysUser);
    }

    @Test
    public void testSelect() {

        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andCreateTimeLessThanOrEqualTo(new Date());
       Page<Object> page = PageHelper.startPage(1, 2);
        List<SysUser> sysUsers = sysUserService.selectByExample(sysUserExample);
        System.out.println(page.getTotal());
        System.out.println(sysUsers);
    }
}
