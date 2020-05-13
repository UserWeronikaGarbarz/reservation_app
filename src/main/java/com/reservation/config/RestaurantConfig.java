package com.reservation.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Getter
@Configuration
@ComponentScan(basePackages = { "com.reservation.*" })
@PropertySource("classpath:application.properties")
public class RestaurantConfig {

    @Value("${info.company.name}")
    private String restaurantName;

    @Value("Sample address")
    private String restaurantAddress;

    @Value("${info.company.email}")
    private String restaurantEmail;

    @Value("${info.company.phone}")
    private String restaurantPhone;
}
