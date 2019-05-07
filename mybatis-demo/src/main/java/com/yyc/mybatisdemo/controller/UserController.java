package com.yyc.mybatisdemo.controller;

import com.yyc.common.info.Message;
import com.yyc.mybatisdemo.entity.SysUser;
import com.yyc.mybatisdemo.entity.SysUserExample;
import com.yyc.mybatisdemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/27: 20:25
 * @Description:
 */
@Controller
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("getUser")
    @ResponseBody
    public Message getUser() {
        SysUserExample sysUserExample = new SysUserExample();
        List<SysUser> list = sysUserService.selectByExample(sysUserExample);
        Message message = new Message();
        Map map = new HashMap();
        map.put("result", list);
        message.setData(map);
        return message;

    }
    @RequestMapping("getUserLazy")
    @ResponseBody
    public SysUser getUserLazy() {
        SysUser sysUser = sysUserService.selectUserAndDeptStep("95");
        return sysUser;

    }
    @RequestMapping("test01")
    @ResponseBody
    public void test01(){
        SysUser sysUser = new SysUser();
        sysUser.setPassword("1112");
        // sysUser.setUserName("1562");
        sysUser.setName("1232");
        sysUser.setDeleteFlag("0");
       // sysUser.setCreateTime(new Date());
        sysUser.setCreateUser("cc");
        String s = sysUserService.selectMaxUserName();
        Long max = (Long.valueOf(s));
        System.out.println(max+"------------");
        max += 1;
        sysUser.setUserName(max.toString());
        sysUserService.insert(sysUser);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
