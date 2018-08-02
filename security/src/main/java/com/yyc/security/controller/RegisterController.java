package com.yyc.security.controller;


import com.yyc.security.exception.UsernameIsExitedException;
import com.yyc.security.pojo.SysUser;
import com.yyc.security.pojo.SysUserExample;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhaoxinguo on 2018/06/05.
 */
@RestController
@RequestMapping("/users")
public class RegisterController extends BaseController {

    /**
     * 注册用户 默认开启白名单
     *
     * @param user
     */
    @PostMapping("/signup")
    public SysUser signup(@RequestBody SysUser user) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        List<SysUser> sysUserList = sysUserService.selectByExample(sysUserExample);
        if (sysUserList.size() > 0) {
            throw new UsernameIsExitedException("用户已经存在");
        }
        user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword()).getBytes()));
        sysUserService.insertSelective(user);
        return user;
    }

}
