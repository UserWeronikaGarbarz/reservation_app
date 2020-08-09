package com.reservation.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailRegistration extends Mail {
    private String password;
    private String username;

    public MailRegistration(String email, String subject, String message, String receiverName, String receiverSurname, String password, String username) {
        super(email, subject, message, receiverName, receiverSurname);
        this.password = password;
        this.username = username;
    }
}
