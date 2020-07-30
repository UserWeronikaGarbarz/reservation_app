package com.reservation.service;

import com.reservation.domain.Guest;
import com.reservation.repository.AutenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GuestAutentication implements AutenticationRepository {

    @Autowired
    private Guest guest;

    @Override
    public String getPassword() {
        return this.guest.getPassword();
    }

    @Override
    public String getUsername() {
        return this.guest.getUsername();
    }

    @Override
    public boolean isEnabled() {
        return this.guest.isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
