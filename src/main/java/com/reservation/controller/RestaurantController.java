package com.reservation.controller;

import com.reservation.dto.RestaurantDto;
import com.reservation.mapper.RestaurantMapper;
import com.reservation.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/restaurants")
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantMapper.mapToListRestaurantDto(restaurantService.getAllRestaurants());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/restaurant", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RestaurantDto createRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return restaurantMapper.mapToRestaurantDto(restaurantService
                .saveRestaurant(restaurantMapper.mapToRestaurant(restaurantDto)));
    }
}
