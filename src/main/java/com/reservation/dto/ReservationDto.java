package com.reservation.dto;

import com.reservation.domain.TableS;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime startOfReservation;
    private LocalDateTime endOfReservation;
    private List<TableS> tableS;
    private LocalDate reservationDone = LocalDate.now();
}