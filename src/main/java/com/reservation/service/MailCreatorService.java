package com.reservation.service;

import com.reservation.config.RestaurantConfig;
import com.reservation.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.Context;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class MailCreatorService {

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    private RestaurantConfig restaurantConfig;

    public String buildEmail(String message, String name, String surname, LocalDate done, LocalDateTime start,
                             LocalDateTime end) {
        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("surname", surname);
        context.setVariable("date", done);
        context.setVariable("start", start);
        context.setVariable("end", end);
        context.setVariable("message", message);
        context.setVariable("button", "See our website");
        context.setVariable("reservation_url", "url_in_future");
        context.setVariable("goodbye", "See you");
        context.setVariable("restaurant_name", restaurantConfig.getRestaurantName());
        context.setVariable("restaurant_adress", restaurantConfig.getRestaurantAddress());
        context.setVariable("restaurant_email", restaurantConfig.getRestaurantEmail());
        return templateEngine.process("mail/confirmation-email", context);
    }

    public String buildEmailRegistration(String message, String name, String surname, String username, String password) {
        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("surname", surname);
        context.setVariable("username", username);
        context.setVariable("password", password);
        context.setVariable("message", message);
        context.setVariable("button", "Confirm your registration");
        context.setVariable("reservation_url", "url_in_future");
        context.setVariable("goodbye", "See you");
        context.setVariable("restaurant_name", restaurantConfig.getRestaurantName());
        context.setVariable("restaurant_adress", restaurantConfig.getRestaurantAddress());
        context.setVariable("restaurant_email", restaurantConfig.getRestaurantEmail());
        return templateEngine.process("mail/registration-email", context);
    }

    public String buildEmail(String message, String name, String surname, String username, String password) {
        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("surname", surname);
        context.setVariable("username", username);
        context.setVariable("password", password);
        context.setVariable("message", message);
        context.setVariable("button", "Confirm your registration");
        context.setVariable("reservation_url", "url_in_future");
        context.setVariable("goodbye", "See you");
        context.setVariable("restaurant_name", restaurantConfig.getRestaurantName());
        context.setVariable("restaurant_adress", restaurantConfig.getRestaurantAddress());
        context.setVariable("restaurant_email", restaurantConfig.getRestaurantEmail());
        return templateEngine.process("mail/registration-email", context);
    }
}
