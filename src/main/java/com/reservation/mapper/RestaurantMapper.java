package com.reservation.mapper;

import com.reservation.domain.Restaurant;
import com.reservation.dto.RestaurantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantMapper {

    @Autowired
    private TableMapper tableMapper;

    public Restaurant mapToRestaurant(RestaurantDto restaurantDto) {
        return new Restaurant(
                restaurantDto.getId(),
                restaurantDto.getName(),
                restaurantDto.getStreet(),
                restaurantDto.getNumber(),
                restaurantDto.getCode(),
                restaurantDto.getEmail(),
                restaurantDto.getPassword(),
                tableMapper.mapToTableList(restaurantDto.getTables()));
    }

    public RestaurantDto mapToRestaurantDto(Restaurant restaurant) {
        return new RestaurantDto(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getStreet(),
                restaurant.getNumber(),
                restaurant.getCode(),
                restaurant.getEmail(),
                restaurant.getPassword(),
                tableMapper.mapToTableDtoList(restaurant.getTables()));
    }

    public List<RestaurantDto> mapToListRestaurantDto(List<Restaurant> restaurantList) {
        return restaurantList.stream()
                .map(r -> new RestaurantDto(r.getId(),
                        r.getName(), r.getStreet(), r.getNumber(), r.getCode(),
                        r.getEmail(), r.getPassword(),
                        tableMapper.mapToTableDtoList(r.getTables())))
                .collect(Collectors.toList());
    }

    public List<Restaurant> mapToListRestaurant(List<RestaurantDto> restaurantDtoList) {
        return restaurantDtoList.stream()
                .map(r -> new Restaurant(r.getId(),
                        r.getName(), r.getStreet(), r.getNumber(), r.getCode(),
                        r.getEmail(), r.getPassword(),
                        tableMapper.mapToTableList(r.getTables())))
                .collect(Collectors.toList());
    }
}
