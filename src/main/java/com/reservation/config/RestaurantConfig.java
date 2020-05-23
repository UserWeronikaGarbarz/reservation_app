package com.reservation.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RestaurantConfig {

    @Value("${info.company.name}")
    private String restaurantName;

    @Value("${info.company.address}")
    private String restaurantAddress;

    @Value("${info.company.email}")
    private String restaurantEmail;

    @Value("${info.company.phone}")
    private String restaurantPhone;
}
