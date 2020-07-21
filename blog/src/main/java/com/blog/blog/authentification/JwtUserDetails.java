package com.blog.blog.authentification;

import com.blog.blog.data.entities.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public class JwtUserDetails implements UserDetails {

    final private UserEntity adminUser;

    public JwtUserDetails(UserEntity adminUser) {
        this.adminUser = adminUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.adminUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.adminUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
