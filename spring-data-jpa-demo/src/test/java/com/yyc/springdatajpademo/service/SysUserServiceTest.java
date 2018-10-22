package com.yyc.springdatajpademo.service;

import com.yyc.springdatajpademo.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/21: 16:25
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysUserServiceTest {
    @Autowired
    private SysUserService sysUserService;

    @Test
    public void pageSelect() {
        sysUserService.findByUserName("13553008642");
        PageRequest of = PageRequest.of(0, 20);
        Page<SysUser> page = sysUserService.findByCreateTimeBefore(new Date(), of);
        System.out.println(page);
    }

}
