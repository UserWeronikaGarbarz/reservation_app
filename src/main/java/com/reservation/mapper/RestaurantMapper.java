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

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private GuestMapper guestMapper;

    public Restaurant mapToRestaurant(RestaurantDto restaurantDto) {
        return new Restaurant(
                restaurantDto.getId(),
                restaurantDto.getName(),
                restaurantDto.getUsername(),
                restaurantDto.getStreet(),
                restaurantDto.getNumber(),
                restaurantDto.getCode(),
                restaurantDto.getEmail(),
                restaurantDto.getPassword(),
                tableMapper.mapToTableList(restaurantDto.getTables()),
                restaurantDto.getLastLoginDate(),
                restaurantDto.getLastLoginDateDisplay(),
                restaurantDto.getJoinDate(),
                reservationMapper.mapToReservationList(restaurantDto.getReservations()),
                guestMapper.mapToGuestList(restaurantDto.getGuests())

        );
    }

    public RestaurantDto mapToRestaurantDto(Restaurant restaurant) {
        return new RestaurantDto(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getUsername(),
                restaurant.getStreet(),
                restaurant.getNumber(),
                restaurant.getCode(),
                restaurant.getEmail(),
                restaurant.getPassword(),
                restaurant.getLastLoginDate(),
                restaurant.getLastLoginDateDisplay(),
                restaurant.getJoinDate(),
                tableMapper.mapToTableDtoList(restaurant.getTables()),
                reservationMapper.mapToReservationDtoList(restaurant.getReservations()),
                guestMapper.mapToGuestDtoList(restaurant.getGuests())
        );
    }

    public List<RestaurantDto> mapToListRestaurantDto(List<Restaurant> restaurantList) {
        return restaurantList.stream()
                .map(r -> new RestaurantDto(
                        r.getId(),
                        r.getName(),
                        r.getUsername(),
                        r.getStreet(),
                        r.getNumber(),
                        r.getCode(),
                        r.getEmail(),
                        r.getPassword(),
                        r.getLastLoginDate(),
                        r.getLastLoginDateDisplay(),
                        r.getJoinDate(),
                        tableMapper.mapToTableDtoList(r.getTables()),
                        reservationMapper.mapToReservationDtoList(r.getReservations()),
                        guestMapper.mapToGuestDtoList(r.getGuests())))
                .collect(Collectors.toList());
    }

    public List<Restaurant> mapToListRestaurant(List<RestaurantDto> restaurantDtoList) {
        return restaurantDtoList.stream()
                .map(r -> new Restaurant(
                        r.getId(),
                        r.getName(),
                        r.getUsername(),
                        r.getStreet(),
                        r.getNumber(),
                        r.getCode(),
                        r.getEmail(),
                        r.getPassword(),
                        tableMapper.mapToTableList(r.getTables()),
                        r.getLastLoginDate(),
                        r.getLastLoginDateDisplay(),
                        r.getJoinDate(),
                        reservationMapper.mapToReservationList(r.getReservations()),
                        guestMapper.mapToGuestList(r.getGuests())))
                .collect(Collectors.toList());
    }
}
