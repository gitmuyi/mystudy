package com.yyc.security.filter;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/22: 20:23
 * @Description:
 */
@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection)
            throws AccessDeniedException, AuthenticationException {
        Iterator<ConfigAttribute> iterator = collection.iterator();
        while (iterator.hasNext()) {
            ConfigAttribute ca = iterator.next();
            //当前请求需要的权限
            String needRole = ca.getAttribute();
            if ("ROLE_LOGIN".equals(needRole)) {
                if (authentication instanceof AnonymousAuthenticationToken) {//判断是不是登陆了
                    throw new BadCredentialsException("未登录");
                } else {//登录了就直接返回，则这个请求将被成功执行。
                    return;
                }
            }
            //当前用户所具有的角色,将当前用户拥有的角色和需要的角色进行比较 如果有能匹配上的就可以了
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

}
