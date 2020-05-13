package com.reservation.service;

import com.reservation.config.RestaurantConfig;
import com.reservation.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.Context;

@Service
public class MailCreatorService {

    @Autowired
    private Reservation reservation;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    private RestaurantConfig restaurantConfig;

    public String buildEmail(String message) {

        Context context = new Context();
        context.setVariable("name", reservation.getName());
        context.setVariable("surname", reservation.getSurname());
        context.setVariable("message", message);
        context.setVariable("button", "Visit website");
        context.setVariable("reservation_url", "url_in_future");
        context.setVariable("goodbye", "Regards");
        context.setVariable("restaurant_name", restaurantConfig.getRestaurantName());
        context.setVariable("restaurant_adress", restaurantConfig.getRestaurantAddress());
        context.setVariable("restaurant_email", restaurantConfig.getRestaurantEmail());
        return templateEngine.process("mail/confirmation-email", context);
    }
}
