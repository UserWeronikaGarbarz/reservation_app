package com.reservation.repository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public interface AutenticationRepository extends UserDetails {

    @Override
    String getPassword();

    @Override
    String getUsername();

    @Override
    boolean isEnabled();

    @Override
    boolean isAccountNonLocked();

    @Override
    boolean isAccountNonExpired();

    @Override
    boolean isCredentialsNonExpired();

    @Override
    Collection<? extends GrantedAuthority> getAuthorities();
}
