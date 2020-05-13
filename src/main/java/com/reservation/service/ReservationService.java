package com.reservation.service;

import com.reservation.domain.Reservation;
import com.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(final Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation saveReservation(final Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(final Long id) {
        reservationRepository.deleteById(id);
    }
}