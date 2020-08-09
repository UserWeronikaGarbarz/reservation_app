package com.reservation.security.service;

import com.reservation.domain.Guest;
import com.reservation.repository.AutenticationRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
@AllArgsConstructor
@Getter
@Setter
public class GuestAutentication implements AutenticationRepository, UserDetails {

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
        return this.guest.isNonLocked();
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
        return stream(this.guest.getAuthorities()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
