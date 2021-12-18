package com.atguigu.atcrowdfunding.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

/**
 * @auther konglingyang
 * @date 2021/12/12 21:22
 */
public class SecurityAdmin extends User {

    private static final long serialVersionUID = 1L;

    private Admin originalAdmin;

    public SecurityAdmin(Admin admin,Collection<GrantedAuthority> authorities) {
        super(admin.getLoginAcct(),
                admin.getUserPswd(),true,true,
                true,true,authorities);
        this.originalAdmin = admin;
        originalAdmin.setUserPswd(null);
    }

    public Admin getOriginalAdmin() {
        return originalAdmin;
    }
}
