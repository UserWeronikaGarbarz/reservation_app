package com.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GuestDto {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private List<ReservationDto> reservationList = new ArrayList<>();
    private List<RestaurantDto> restaurantDtoList = new ArrayList<>();
}
