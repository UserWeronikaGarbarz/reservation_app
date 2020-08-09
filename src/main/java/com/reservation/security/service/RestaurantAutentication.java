package com.reservation.security.service;

import com.reservation.domain.Restaurant;
import com.reservation.repository.AutenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class RestaurantAutentication implements AutenticationRepository {

    @Autowired
    private Restaurant restaurant;

    @Override
    public String getPassword() {
        return this.restaurant.getPassword();
    }

    @Override
    public String getUsername() {
        return this.restaurant.getUsername();
    }

    @Override
    public boolean isEnabled() {
        return this.restaurant.isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
