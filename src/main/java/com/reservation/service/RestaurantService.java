package com.reservation.service;

import com.reservation.domain.Restaurant;
import com.reservation.repository.RestaurantRepository;
import com.reservation.security.jwt.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JWTTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Autowired
    private MailService mailService;





    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant addRestaurant(final Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public void updateProfileImage(String username, MultipartFile profileImage) {

    }
    public Restaurant findRestaurantByName(String name) {
        return restaurantRepository.findRestaurantByName(name);
    }

    public Restaurant updateRestaurant(final Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public void resetPassword(String email) {

    }

    public void deleteRestaurant(int id) {
        restaurantRepository.deleteById(id);
    }
}
