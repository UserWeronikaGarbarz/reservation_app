package com.reservation.security.configuration;

public class Authorities {
    public static final String[] GUEST_AUTHORITIES = { "user:read", "user:update", "user:delete" };
    public static final String[] RESTAURANT_AUTHORITIES = { "user:read", "user:update", "user:create" };
    public static final String[] MANAGER_AUTHORITIES = { "user:read", "user:update", "user:delete", "user:create" };
}
