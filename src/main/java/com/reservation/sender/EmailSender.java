package com.reservation.sender;

import com.reservation.controller.ReservationController;
import com.reservation.domain.Mail;
import com.reservation.domain.Reservation;
import com.reservation.dto.ReservationDto;
import com.reservation.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmailSender {

    @Autowired
    private MailService mailService;


    private static final String SUBJECT = "Your reservation has been created!";

//    public Reservation sendConfirmationEmail(ReservationDto reservationDto) {
//        Optional.ofNullable(reservationCreated).ifPresent(r ->
//                mailService.send(new Mail(reservationDto.getEmail(), SUBJECT, "Reservation number: "
//                        + reservationDto.getId())));
//        return reservationCreated;
//    }
}
