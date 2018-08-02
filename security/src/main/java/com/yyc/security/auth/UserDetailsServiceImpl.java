package com.yyc.security.auth;


import com.yyc.security.pojo.SysRole;
import com.yyc.security.pojo.SysUser;
import com.yyc.security.pojo.SysUserExample;
import com.yyc.security.service.SysRoleService;
import com.yyc.security.service.SysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private SysUserService sysUserService;

    private SysRoleService sysRoleService;

    /**
     * 通过构造器注入UserRepository
     *
     * @param sysUserService
     */
    public UserDetailsServiceImpl(SysUserService sysUserService, SysRoleService sysRoleService) {
        this.sysUserService = sysUserService;
        this.sysRoleService = sysRoleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<SysUser> sysUserList = sysUserService.selectByExample(sysUserExample);
        if (sysUserList.size() == 0) {
            throw new UsernameNotFoundException(username);
        }
        SysUser user = sysUserList.get(0);
        List<GrantedAuthority> list = authorities(user.getId());

        return new User(user.getUserName(), user.getPassword(), list);
    }

    /**
     * 查询角色信息
     *
     * @param userId
     * @return
     */
    public List<GrantedAuthority> authorities(String userId) {
        List<SysRole> sysRoles = sysRoleService.findRoleByUserId(userId);
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        for (SysRole sysRole : sysRoles) {
            authorities.add(new GrantedAuthorityImpl(sysRole.getRole()));
        }
        return authorities;
    }
}
