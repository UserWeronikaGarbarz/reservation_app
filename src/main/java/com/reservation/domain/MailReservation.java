package com.reservation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MailReservation extends Mail {
    private LocalDateTime start;
    private LocalDateTime end;
    private LocalDate done;

    public MailReservation(String email, String subject, String message, String receiverName, String receiverSurname, LocalDateTime start, LocalDateTime end, LocalDate done) {
        super(email, subject, message, receiverName, receiverSurname);
        this.start = start;
        this.end = end;
        this.done = done;
    }
}
