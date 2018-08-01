package com.yyc.security.auth;

import com.yyc.security.pojo.SysUser;

/**
 * @Auther: yangyongcui
 * @Date: 2018/8/1: 18:50
 * @Description:
 */
public interface IUserService {
    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return 操作结果
     */
    String login(String userName, String password);

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return 操作结果
     */
    String register(SysUser user);

    /**
     * 刷新密钥
     *
     * @param oldToken 原密钥
     * @return 新密钥
     */
    String refreshToken(String oldToken);
}
