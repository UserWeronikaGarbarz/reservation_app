package com.reservation;

import com.reservation.config.RestaurantConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(AppConfiguration.class, args);

        RestaurantConfig restaurantConfig = new RestaurantConfig();
        System.out.println("sample text");
        System.out.println(restaurantConfig.getRestaurantAddress());
    }
}
