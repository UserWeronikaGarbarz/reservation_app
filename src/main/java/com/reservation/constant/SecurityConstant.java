package com.reservation.constant;

public class SecurityConstant {
    public static final String TOKEN_HEADER = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String GET_ARRAYS_LCC = "Get Arrays, LCC";
    public static final String GET_ARRAYS_ADMINISTRATION = "Management Portal";
    public static final String AUTHORITIES = "authorities";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    public static final String FORBIDDEN_MESSAGE = "You need to login to access this page.";
    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this page.";
    public static final String[] PUBLIC_URLS = { "/v1/guest/login", "/v1/guest/register", "/v1/guest/resetpassword/**",
    "/v1/restaurant/getall", "/v1/reservation/create", "/v1/table/getavailable", "/v1/restaurant/login",
    "v1/restaurant/register", "/v1/restaurant/resetpassword/**", "/v1/guest/showall"};
}
