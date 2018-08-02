package com.yyc.security.controller;

import com.yyc.security.pojo.SysUser;
import com.yyc.security.pojo.SysUserExample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {
    /**
     * 获取用户列表
     *
     * @return
     */
    @GetMapping("/userList")
    public Map<String, Object> userList() {
        SysUserExample sysUserExample = new SysUserExample();
        List<SysUser> users = sysUserService.selectByExample(sysUserExample);
        logger.info("users: {}", users);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("users", users);
        return map;
    }

    @GetMapping("/authorityList")
    public List<String> authorityList() {
        List<String> authentication = getAuthentication();
        return authentication;
    }

}
