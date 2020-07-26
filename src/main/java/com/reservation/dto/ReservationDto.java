package com.reservation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDateTime startOfReservation;
    private LocalDateTime endOfReservation;
    private List<TableDto> tableDtos = new ArrayList<>();
    private LocalDate reservationDone = LocalDate.now();
    private Long restaurantId;

    public ReservationDto(final Long id, final String name, final String surname, final String email,
                          final LocalDateTime startOfReservation, final LocalDateTime endOfReservation,
                          final List<TableDto> tableDtos, final Long restaurantId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.startOfReservation = startOfReservation;
        this.endOfReservation = endOfReservation;
        this.tableDtos = tableDtos;
        this.restaurantId = restaurantId;
    }
}