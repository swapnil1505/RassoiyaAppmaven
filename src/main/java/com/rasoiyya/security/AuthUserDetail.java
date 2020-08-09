package com.rasoiyya.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rasoiyya.domain.UserLogin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Manish
 */
public class AuthUserDetail extends UserLogin implements UserDetails {

    public AuthUserDetail(UserLogin user) {
        super(user);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

       grantedAuthorities.add(new SimpleGrantedAuthority(getRoles().getRoleName()));
        return grantedAuthorities;
    }


	@Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return super.getIsActive();
    }
}
