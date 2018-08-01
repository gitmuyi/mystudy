package com.yyc.security.auth;

import com.yyc.security.pojo.SysRole;
import com.yyc.security.pojo.SysUser;
import com.yyc.security.pojo.SysUserExample;
import com.yyc.security.service.SysRoleService;
import com.yyc.security.service.SysUserRoleService;
import com.yyc.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: yangyongcui
 * @Date: 2018/8/1: 18:20
 * @Description:
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<SysUser> user = sysUserService.selectByExample(sysUserExample);
        if (user == null || user.size() == 0) {
            throw new UsernameNotFoundException(String.format("用户名不存在 username '%s'.", username));
        } else {
            SysUser sysUser = user.get(0);
            List<SysRole> list = sysRoleService.findRoleByUserId(sysUser.getId());
            List roles = new ArrayList();
            for (SysRole sysRole : list) {
                roles.add(new SimpleGrantedAuthority(sysRole.getRole()));
            }
            return new JwtUser(sysUser.getUserName(), sysUser.getPassword(), roles);
        }
    }

}
