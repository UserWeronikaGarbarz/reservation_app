package com.reservation.service;

import com.reservation.domain.Mail;
import com.reservation.domain.Reservation;
import com.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private MailService mailService;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(final Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation saveReservation(final Reservation reservation) {
        Reservation savedReservation = reservationRepository.save(reservation);
        mailService.send(new Mail(reservation.getEmail(), "Reservation", "Your reservation has been registered"));
        return savedReservation;
    }

    public void deleteReservation(final Long id) {
        reservationRepository.deleteById(id);
    }

    public void deleteCompletedReservation(LocalDateTime dateTime) {
        reservationRepository.deleteReservation(dateTime);
    }
}