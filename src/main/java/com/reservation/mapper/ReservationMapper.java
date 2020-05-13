package com.reservation.mapper;

import com.reservation.domain.Reservation;
import com.reservation.dto.ReservationDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationMapper {
    public Reservation mapToReservation(final ReservationDto reservationDto) {
        return new Reservation(
                reservationDto.getId(),
                reservationDto.getName(),
                reservationDto.getSurname(),
                reservationDto.getEmail(),
                reservationDto.getDateOfReservation(),
                reservationDto.getTables(),
                reservationDto.getReservationDone()
        );
    }

    public ReservationDto mapToReservationDto(final Reservation reservation) {
        return new ReservationDto(
                reservation.getId(),
                reservation.getName(),
                reservation.getSurname(),
                reservation.getEmail(),
                reservation.getDateOfReservation(),
                reservation.getTables(),
                reservation.getReservationDone()
        );
    }

    public List<ReservationDto> mapToReservationDtoList(final List<Reservation> reservationList) {
        return reservationList.stream()
                .map(r -> new ReservationDto(r.getId(), r.getName(), r.getSurname(), r.getEmail(),
                        r.getDateOfReservation(), r.getTables(),
                        r.getReservationDone())).collect(Collectors.toList());
    }
}
