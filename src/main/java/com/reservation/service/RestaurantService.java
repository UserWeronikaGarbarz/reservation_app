package com.reservation.service;

import com.reservation.domain.Restaurant;
import com.reservation.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant saveRestaurant(final Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
