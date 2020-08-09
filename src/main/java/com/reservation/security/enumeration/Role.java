package com.reservation.security.enumeration;

import static com.reservation.security.configuration.Authorities.*;

public enum Role {
    ROLE_GUEST(GUEST_AUTHORITIES),
    ROLE_RESTAURANT(RESTAURANT_AUTHORITIES),
    ROLE_MANAGER(MANAGER_AUTHORITIES);

    private String[] authorities;

    Role(String... authorities) {
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }
}
