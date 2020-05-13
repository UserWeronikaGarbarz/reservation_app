package com.reservation.dto;

import com.reservation.domain.TableS;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDateTime dateOfReservation;
    private List<TableS> tables = new ArrayList<>();
    private Date reservationDone;
}