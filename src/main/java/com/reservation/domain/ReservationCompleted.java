package com.reservation.domain;

import com.reservation.service.ReservationService;
import com.reservation.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ReservationCompleted {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private TableService tableService;

    @Scheduled(cron = "0 0/15 * * * *")
    public void deleteReservation() {
        LocalDateTime currentDate = LocalDateTime.now();

        List<Long> reservationId = reservationService.findReservationId(currentDate);
        reservationId.forEach(i -> tableService.updateTableS(i));
        reservationService.deleteCompletedReservation(currentDate);
    }
}