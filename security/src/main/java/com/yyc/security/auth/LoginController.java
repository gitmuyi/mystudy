package com.yyc.security.auth;


import com.yyc.security.constant.Message;
import com.yyc.security.entity.SysMenu;
import com.yyc.security.entity.SysUser;
import com.yyc.security.entity.SysUserExample;
import com.yyc.security.enums.UserCodeEnum;
import com.yyc.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/22: 15:48
 * @Description:
 */
@Controller
public class LoginController {
    @Autowired
    SysUserService sysUserService;


    @RequestMapping("/index")
    public String loginSuccess() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "index";
    }

    @RequestMapping("/xiaoshouyeji")
    public String xiaoShouYeJi() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "page/xiaoshouyeji";
    }
    /**
     * 用户进行注册
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/register.json")
    @ResponseBody
    public Message register(String username, String password, String name) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<SysUser> list = sysUserService.selectByExample(sysUserExample);
        Message message = new Message();
        if (list.size() > 0) {
            return message.failed(UserCodeEnum.EXISTED.getCode(), "该用户已经存在");
        }
        password = new BCryptPasswordEncoder().encode(password);
        SysMenu sysMenu=new SysMenu();
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);
        sysUser.setPassword(password);
        sysUser.setCreateUser(username);//此时的创建人将会使用注册的用户名
        sysUser.setCreateTime(new Date());
        sysUser.setName(name);
        sysUser.setDeleteFlag("0");
        int i = sysUserService.insertSelective(sysUser);
        if (i > 0) {
            return message;
        }
        return message.failed();

    }

    /**
     * 用户进行注册
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping("/register")
    public String register() {
        return "page/register";
    }
}
