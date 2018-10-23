package com.yyc.security.filter;

import com.yyc.security.entity.*;
import com.yyc.security.service.SysMenuService;
import com.yyc.security.service.SysRoleMenuService;
import com.yyc.security.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.*;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/22: 19:34
 * @Description:
 */
@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @Autowired
    private SysRoleService sysRoleService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取请求地址
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        if ("/login".equals(requestUrl)||"/register".equals(requestUrl)) {
            return null;
        }
        if(antPathMatcher.matchStart("/register.*",requestUrl)){
            return null;
        }



        List<SysMenu> allMenu = sysMenuService.selectByExample(new SysMenuExample());
        SysRoleMenuExample sysRoleMenuExample;
        for (SysMenu menu : allMenu) {
            //根据请求的路径去查询该路径需要哪些角色可以访问，根绝当前的设计的数据库的关系，通过角色--菜单表 查询
            sysRoleMenuExample = new SysRoleMenuExample();
            SysRoleMenuExample.Criteria criteria = sysRoleMenuExample.createCriteria();
            criteria.andMenuIdEqualTo(menu.getId());
            List<SysRoleMenu> sysRoleMenus = sysRoleMenuService.selectByExample(sysRoleMenuExample);
            if (menu.getMenuSrc() == null || menu.getMenuSrc().equals("")) {
                continue;
            }
            if (antPathMatcher.match(menu.getMenuSrc(), requestUrl) && sysRoleMenus.size() > 0) {//如果请求的路径数据库中维护了，并且该路径需要某些角色才能访问
                //根据查询到的 SysRoleMenu 的关系。去循环查询角色名称
                //从集合中取出角色id来
                List<String> list = new ArrayList<>();
                for (SysRoleMenu sysRoleMenu : sysRoleMenus) {
                    list.add(sysRoleMenu.getRoleId());
                }
                SysRoleExample sysRoleExample = new SysRoleExample();
                SysRoleExample.Criteria criteria1 = sysRoleExample.createCriteria();
                criteria1.andIdIn(list);

                List<SysRole> sysRoles = sysRoleService.selectByExample(sysRoleExample);
                String roles[] = new String[sysRoles.size()];
                for (int i = 0; i < sysRoles.size(); i++) {
                    roles[i] = sysRoles.get(i).getRole();
                }
                return SecurityConfig.createList(roles);
            }
        }
        //没有匹配上的资源，都是登录访问 return SecurityConfig.createList("ROLE_LOGIN");
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
