package com.reservation.controller;

import com.reservation.domain.Reservation;
import com.reservation.dto.ReservationDto;
import com.reservation.mapper.ReservationMapper;
import com.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationMapper reservationMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/reservations")
    public List<ReservationDto> getAllReservations() {
        return reservationMapper.mapToReservationDtoList(reservationService.getAllReservations());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/reservations", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Reservation createReservation(@RequestBody ReservationDto reservationDto) {
        return reservationService.saveReservation(reservationMapper.mapToReservation(reservationDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/reservations/{reservationId}")
    public void deleteReservation(@PathVariable Long reservationId) {
        reservationService.deleteReservation(reservationId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reservations/{reservationId}")
    public ReservationDto getReservation(@PathVariable Long reservationId) throws ReservationNotFoundException {
        return reservationMapper.mapToReservationDto(reservationService.getReservationById(reservationId)
                .orElseThrow(ReservationNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/reservations")
    public ReservationDto updateReservation(@RequestBody ReservationDto reservationDto) {
        return reservationMapper.mapToReservationDto(reservationService.saveReservation
                (reservationMapper.mapToReservation(reservationDto)));
    }
}