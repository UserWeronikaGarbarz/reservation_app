package com.reservation.security.service;

import com.reservation.domain.Restaurant;
import com.reservation.repository.AutenticationRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
@Getter
@Setter
public class RestaurantAutentication implements AutenticationRepository, UserDetails {

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
