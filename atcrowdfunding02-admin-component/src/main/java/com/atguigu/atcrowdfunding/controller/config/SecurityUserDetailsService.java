package com.atguigu.atcrowdfunding.controller.config;

import com.atguigu.atcrowdfunding.entity.Admin;
import com.atguigu.atcrowdfunding.entity.Auth;
import com.atguigu.atcrowdfunding.entity.Role;
import com.atguigu.atcrowdfunding.entity.SecurityAdmin;
import com.atguigu.atcrowdfunding.service.AdminService;
import com.atguigu.atcrowdfunding.service.AuthService;
import com.atguigu.atcrowdfunding.service.RoleService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @auther konglingyang
 * @date 2021/12/12 21:29
 */
@Component
public class SecurityUserDetailsService implements UserDetailsService {

    @Resource
    private AdminService adminService;
    @Resource
    private RoleService roleService;
    @Resource
    private AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 1.根据用户名从数据库中查询Admin对象
        Admin admin = adminService.getAdminByUserName(username);
        // 2.取出admin的password
        //String userPswd = admin.getUserPswd();
        // 3.取出adminId
        Integer adminId = admin.getId();

        // 4.创建集合来储存角色和权限
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        // 5.根据adminId查询对应的角色， 并添加到authorities中
        List<Role> roleList = roleService.getRolesAssignByAdmin(adminId);
        for (Role role : roleList) {
            String roleName = role.getName();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + roleName));
        }

        // 6.根据adminId查询对应的权限， 并添加到authorities中
        List<String> authLIst = authService.getAssignedAuthListByAdminId(adminId);
        for (String authName : authLIst) {
            authorities.add(new SimpleGrantedAuthority(authName));
        }

        // 7.封装到User的子类SecurityAdmin对象中
        SecurityAdmin securityAdmin = new SecurityAdmin(admin, authorities);
        return securityAdmin;
    }
}
