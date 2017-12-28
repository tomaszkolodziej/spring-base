package com.tolean.elab.persistence.profile;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by Tomasz Kołodziej
 */
public class ProfileDetail implements UserDetails {

    private Profile profile;

    public ProfileDetail(Profile profile) {
        this.profile = profile;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Lists.newArrayList();
    }

    public String getPassword() {
        return profile.getPassword();
    }

    public String getUsername() {
        return profile.getLogin();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return profile.isActive();
    }

}
