package com.yyc.mybatisdemo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyc.mybatisdemo.dao.SysDeptMapper;
import com.yyc.mybatisdemo.dao.SysUserDynamicSqlMapper;
import com.yyc.mybatisdemo.dao.SysUserMapper;
import com.yyc.mybatisdemo.entity.SysDept;
import com.yyc.mybatisdemo.entity.SysUser;
import com.yyc.mybatisdemo.entity.SysUserExample;
import com.yyc.mybatisdemo.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
        PageHelper.startPage(1, 2);
        List<SysUser> sysUsers = sysUserService.selectByExample(sysUserExample);
        System.out.println(sysUsers);
        PageInfo pageInfo = new PageInfo(sysUsers);
    }

    @Test
    public void selectUserAndDept() {
        SysUser sysUser = sysUserService.selectUserAndDept("95");
        System.out.println(sysUser);
        System.out.println(sysUser.getSysDept());
    }

    @Test
    public void selectUserAndDeptStep() {
        SysUser sysUser = sysUserService.selectUserAndDeptStep("95");
        System.out.println(sysUser);
        // System.out.println(sysUser.getSysDept());
    }

    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    SysUserDynamicSqlMapper sysUserDynamicSqlMapper;

    @Test
    public void selectByIdStep() {
        /*List<SysUser> userByDeptId = sysUserMapper.getUserByDeptId("1");
        System.out.println(userByDeptId);*/
       /* SysDept sysDept = sysDeptMapper.selectByIdStep("1");
        System.out.println(sysDept);*/
        SysDept sysDept1 = sysDeptMapper.selectDeptAndUserByDeptId("1");
        System.out.println(sysDept1.getDeptName());
        System.out.println(sysDept1.getSysUsers());

    }

    @Test
    public void selectByIdDynamic() {
        SysUser sysUser = sysUserDynamicSqlMapper.selectUserById("95");
        System.out.println(sysUser);
        sysUser = new SysUser();
        sysUser.setId("95");
        sysUser.setDeptId("1");
        List<SysUser> list = sysUserDynamicSqlMapper.selectSysUserWithIf(sysUser);
        System.out.println(list);
    }

    @Test
    @Transactional
    @Rollback(value = false)//默认是true  即使不抛异常, 事务照样会回滚,所以写成false
    public void testTrans() {
        SysUser sysUser = new SysUser();
        sysUser.setPassword("1112");
       // sysUser.setUserName("1562");
        sysUser.setName("1232");
        sysUser.setDeleteFlag("0");
        sysUser.setCreateTime(new Date());
        sysUser.setCreateUser("cc");
        String s = sysUserService.selectMaxUserName();
        Long max = (Long.valueOf(s));
        max += 1;
        sysUser.setUserName(max.toString());
        sysUserService.insert(sysUser);
        List<SysUser> list = sysUserService.selectByExample(null);
    }
}