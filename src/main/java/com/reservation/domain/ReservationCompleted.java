package com.reservation.domain;

import com.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReservationCompleted {

    @Autowired
    private ReservationService reservationService;

    @Scheduled(cron = "0 0/15 * * * *")
    public void deleteReservation() {
        LocalDateTime currentDate = LocalDateTime.now();
        reservationService.deleteCompletedReservation(currentDate);
    }
}