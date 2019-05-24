package cn.middle.web.shiro.realm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import cn.middle.pojo.SysMenu;
import cn.middle.pojo.SysRole;
import cn.middle.pojo.SysUser;
import cn.middle.service.LoginService;
import cn.middle.service.SysMenuService;
import cn.middle.service.SysRoleService;
import cn.middle.service.SysUserService;

/**
 * @program: shiro
 * @description: 自定义Realm
 * @author: 01
 * @create: 2018-09-08 16:13
 **/
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;
    
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;
    
    @Autowired
    private SysMenuService sysMenuService;
    
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        
        if(principals == null){  
            throw new AuthorizationException("principals should not be null");  
        }
        
        // 从session中拿出用户对象
        SysUser user = (SysUser) principals.fromRealm(this.getClass().getName()).iterator().next();
        // 权限集合
        List<String> permissionList = new ArrayList<>();
        // 角色集合
        Set<String> roleNameSet = new HashSet<>();
        // 获取用户的角色集
        SysRole roleVo = new SysRole();
        roleVo.setUserId(user.getUserId());
        roleVo.setDelFlag("0");
        List<SysRole> roleSet = sysRoleService.selectRoleByUserId(roleVo);
        
        if (!CollectionUtils.isEmpty(roleSet)) {
            for (SysRole role : roleSet) {
                // 添加角色名称
                roleNameSet.add(role.getRoleName());
            }
        }
        
        // 获取用户的菜单集
        SysMenu menuVo = new SysMenu();
        menuVo.setUserId(user.getUserId());
        menuVo.setDelFlag("0");
        List<SysMenu> menuSet = sysMenuService.selectMenuByUserId(menuVo);
        
        if (!CollectionUtils.isEmpty(menuSet)) {
            for (SysMenu permission : menuSet) {
                // 添加权限名称
                permissionList.add(permission.getPermission());
            }
        }
        
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        info.setRoles(roleNameSet);
        return info;
    }
    
    // 认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
            throws AuthenticationException {
        
        // 加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (token.getPrincipal() == null) {
            return null;
        }
        String userCode = (String) token.getPrincipal();
        // String password = new String((char[]) token.getCredentials());
        // 通过userName从数据库中查找 User对象，这里可以根据实际情况做缓存，如果不做，shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUser userInfo = loginService.findByUserCode(userCode);
        if (userInfo == null)
            return null;
        else{
            System.out.println("----->>userInfo=" + userInfo.getUserName() + "---"+ userInfo.getPassword());
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    userInfo, // 用户名
                    userInfo.getPassword(), // 密码
                    getName() // realm name
            );
            return authenticationInfo;
        }
        /*UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        // 获取登录的用户名
        String userName = usernamePasswordToken.getUsername();
        // 从数据库中查询用户
        SysUser user = userService.findByUserName(userName);
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());*/
    }
    
}