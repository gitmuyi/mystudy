package com.yyc.shiro.auth;

import com.yyc.shiro.pojo.*;
import com.yyc.shiro.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/29: 14:01
 * @Description:
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysPermissionService sysPermissionService;
    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("--------------执行Shiro权限获取----------------------");
        System.out.println("执行Shiro权限获取");
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (primaryPrincipal instanceof SysUser) {
            SysUser sysUserLogin = (SysUser) primaryPrincipal;
            //给用户添加角色和权限信息
            addRolesAndPermissions(authorizationInfo, sysUserLogin.getUserId());
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("---------------- 执行 Shiro 凭证认证 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String name = token.getUsername();
        String password = String.valueOf(token.getPassword());
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUsernameEqualTo(name);
        criteria.andPasswordEqualTo(password);
        List<SysUser> sysUsers = sysUserService.selectByExample(sysUserExample);
        if (sysUsers.isEmpty()) {
            throw new UnknownAccountException();
        }
        SysUser sysUser = sysUsers.get(0);
        if (sysUser.getStatus() != 1) {
            throw new DisabledAccountException();
        }
        log.info("---------------------Shiro 凭证认证成功---------------------------------");
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), getName());
        return authenticationInfo;
    }


    /**
     * 根据用户id 查询所对应的所有角色并返回
     *
     * @return
     */
    public void addRolesAndPermissions(SimpleAuthorizationInfo authorizationInfo, String userId) {
        if (StringUtils.isEmpty(userId)) {
            return;
        }
        //根据用户信息查询该用户所拥有的角色
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        sysUserRoleExample.createCriteria().andUserIdEqualTo(userId);
        //得到该用户的角色ids
        List<SysUserRole> sysUserRoles = sysUserRoleService.selectByExample(sysUserRoleExample);
        List<Integer> rolesId = new ArrayList<>();
        for (SysUserRole userRole : sysUserRoles) {
            rolesId.add(userRole.getRoleId());
        }
        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andIdIn(rolesId);
        //得到了该用户的所有角色
        List<SysRole> sysRoles = sysRoleService.selectByExample(sysRoleExample);
        Set<String> setRoles = new HashSet<>();//转换成set 集合
        for (SysRole sysRole : sysRoles) {
            setRoles.add(sysRole.getName());
        }
        authorizationInfo.addRoles(setRoles);
        //添加权限信息
        addPermissions(authorizationInfo, rolesId);
    }

    /**
     * 根据角色id 得到 该角色所拥有的权限
     * 将他能访问的url 返回
     *
     * @param roleIds
     * @return
     */
    public void addPermissions(SimpleAuthorizationInfo authorizationInfo, List<Integer> roleIds) {
        if (roleIds.isEmpty()) {
            return;
        }
        //根据角色id 先去得到角色和权限的关系表
        SysRolePermissionExample sysRolePermissionExample = new SysRolePermissionExample();
        sysRolePermissionExample.createCriteria().andRoleIdIn(roleIds);
        //得到该角色和权限的关系数据
        List<SysRolePermission> sysRolePermissions = sysRolePermissionService.selectByExample(sysRolePermissionExample);
        List<Integer> permissionIds = new ArrayList<>();
        for (SysRolePermission sysRolePermission : sysRolePermissions) {
            permissionIds.add(sysRolePermission.getPermissionId());
        }
        //根据权限id查询对应的权限数据
        SysPermissionExample sysPermissionExample = new SysPermissionExample();
        sysPermissionExample.createCriteria().andIdIn(permissionIds);
        List<SysPermission> sysPermissions = sysPermissionService.selectByExample(sysPermissionExample);
        //将得到的权限的信息里面的url 信息放到set集合中
        Set<String> set = new HashSet<>();
        for (SysPermission sysPermission : sysPermissions) {
            set.add(sysPermission.getUrl());
        }
        authorizationInfo.addStringPermissions(set);
    }


}
