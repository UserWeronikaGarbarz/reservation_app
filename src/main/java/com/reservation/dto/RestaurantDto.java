package com.reservation.dto;

import com.reservation.domain.Guest;
import com.reservation.domain.Reservation;
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
public class RestaurantDto {
    private int id;
    private String name;
    private String username;
    private String street;
    private int number;
    private String code;
    private String email;
    private String password;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;
    private List<TableDto> tables = new ArrayList<>();
    private List<ReservationDto> reservations = new ArrayList<>();
    private List<GuestDto> guests = new ArrayList<>();
}
