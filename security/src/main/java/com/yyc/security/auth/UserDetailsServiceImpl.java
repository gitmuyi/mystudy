package com.yyc.security.auth;



import com.yyc.security.entity.SysRole;
import com.yyc.security.entity.SysUser;
import com.yyc.security.entity.SysUserExample;
import com.yyc.security.business.SysRoleBusiness;
import com.yyc.security.business.SysUserBusiness;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private SysUserBusiness sysUserBusiness;

    private SysRoleBusiness sysRoleBusiness;

    /**
     * 通过构造器注入UserRepository
     *
     * @param sysUserService
     */
    public UserDetailsServiceImpl(SysUserBusiness sysUserService, SysRoleBusiness sysRoleService) {
        this.sysUserBusiness = sysUserService;
        this.sysRoleBusiness = sysRoleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<SysUser> sysUserList = sysUserBusiness.selectByExample(sysUserExample);
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
        List<SysRole> sysRoles = sysRoleBusiness.findRoleByUserId(userId);
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        for (SysRole sysRole : sysRoles) {
            authorities.add(new SimpleGrantedAuthority(sysRole.getRole()));
        }
        return authorities;
    }
}
