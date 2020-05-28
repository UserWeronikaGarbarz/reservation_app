package com.reservation.mapper;

import com.reservation.domain.Reservation;
import com.reservation.dto.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationMapper {

    @Autowired
    private TableMapper tableMapper;

    public Reservation mapToReservation(final ReservationDto reservationDto) {
        return new Reservation(
                reservationDto.getName(),
                reservationDto.getSurname(),
                reservationDto.getEmail(),
                reservationDto.getStartOfReservation(),
                reservationDto.getEndOfReservation(),
                tableMapper.mapToTableList(reservationDto.getTableDtos())
        );
    }

    public ReservationDto mapToReservationDto(final Reservation reservation) {
        return new ReservationDto(
                reservation.getId(),
                reservation.getName(),
                reservation.getSurname(),
                reservation.getEmail(),
                reservation.getStartOfReservation(),
                reservation.getEndOfReservation(),
                tableMapper.mapToTableDtoList(reservation.getTableS())
        );
    }

    public List<ReservationDto> mapToReservationDtoList(final List<Reservation> reservationList) {
        return reservationList.stream()
                .map(r -> new ReservationDto(r.getId(), r.getName(), r.getSurname(), r.getEmail(),
                        r.getStartOfReservation(), r.getEndOfReservation(),
                        tableMapper.mapToTableDtoList(r.getTableS())))
                .collect(Collectors.toList());
    }
}