package com.blog.blog.authentification;

import com.blog.blog.data.entities.UserEntity;
import com.blog.blog.models.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final AdminUserService adminUserService;

    public JwtUserDetailsService(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity adminUser = adminUserService.getUserByUserName(username);
        if (adminUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new JwtUserDetails(adminUser);
    }


    public UserInfo getUserInfo() {
        return new UserInfo(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
