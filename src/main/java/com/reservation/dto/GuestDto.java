package com.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GuestDto {
    private int id;
    private String userId;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;
    private boolean active;
    private boolean nonLocked;
    private String[] authorities;
    private String role;
    private List<ReservationDto> reservationDtoList = new ArrayList<>();
    private List<RestaurantDto> restaurantDtoList = new ArrayList<>();
}
