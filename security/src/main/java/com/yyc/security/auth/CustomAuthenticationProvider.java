package com.yyc.security.auth;

;
import com.yyc.security.entity.SysRole;
import com.yyc.security.entity.SysUser;
import com.yyc.security.entity.SysUserExample;
import com.yyc.security.business.SysRoleBusiness;
import com.yyc.security.business.SysUserBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义身份认证验证组件
 *没有用到
 * @author zhaoxinguo on 2017/9/12.
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private SysRoleBusiness sysRoleBusiness;
    @Autowired
    private SysUserBusiness sysUserBusiness;

    public CustomAuthenticationProvider(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证的用户名 & 密码
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        // 认证逻辑
        UserDetails userDetails = userDetailsService.loadUserByUsername(name);
        if (null != userDetails) {
            String encodePassword = DigestUtils.md5DigestAsHex((password).getBytes());
            if (userDetails.getPassword().equals(encodePassword)) {
                // 这里设置权限和角色
                List<GrantedAuthority> authorities = setAuthorities(userDetails.getUsername());
                // 生成令牌 这里令牌里面存入了:name,password,authorities, 当然你也可以放其他内容
                Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
                return auth;
            } else {
                throw new BadCredentialsException("密码错误");
            }
        } else {
            throw new UsernameNotFoundException("用户不存在");
        }
    }

    /**
     * 是否可以提供输入类型的认证服务
     *
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    /**
     * 查询角色信息
     *
     * @param userName
     * @return
     */
    public List<GrantedAuthority> setAuthorities(String userName) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<SysUser> sysUser = sysUserBusiness.selectByExample(sysUserExample);
        if (sysUser.isEmpty()) {
            return new ArrayList<>();
        }
        SysUser user = sysUser.get(0);
        List<SysRole> sysRoles = sysRoleBusiness.findRoleByUserId(user.getId());
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        for (SysRole sysRole : sysRoles) {
            authorities.add(new SimpleGrantedAuthority(sysRole.getRole()));
        }
        return authorities;
    }
}
