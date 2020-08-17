package com.reservation.service;

import com.reservation.domain.MailRegistration;
import com.reservation.domain.MailReservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailCreatorService mailCreatorService;

    public void send(final MailReservation mailReservation) {
        LOGGER.info("Starting email preparation...");
        try {
            javaMailSender.send(createMimeMessage(mailReservation));
        } catch (MailException e) {
            LOGGER.error("Failed to process email sending" + e.getMessage(), e);
        }
        LOGGER.info("Email has been sent");
    }

    public void send(final MailRegistration mailRegistration) {
        LOGGER.info("Starting email preparation...");
        try {
            javaMailSender.send(createMimeMessage(mailRegistration));
        } catch (MailException e) {
            LOGGER.error("Failed to process email sending" + e.getMessage(), e);
        }
        LOGGER.info("Email has been sent");
    }

    public void sendPasswordEmail() {

    }

    private MimeMessagePreparator createMimeMessage(final MailRegistration mailRegistration) {
        return mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setTo(mailRegistration.getEmail());
            mimeMessageHelper.setSubject(mailRegistration.getSubject());
            mimeMessageHelper.setText(mailCreatorService.buildEmailRegistration(mailRegistration.getMessage(),
                    mailRegistration.getReceiverName(), mailRegistration.getReceiverSurname(),
                    mailRegistration.getUsername(), mailRegistration.getPassword()), true);
        };
    }

    private MimeMessagePreparator createMimeMessage(final MailReservation mailReservation) {
        return mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setTo(mailReservation.getEmail());
            mimeMessageHelper.setSubject(mailReservation.getSubject());
            mimeMessageHelper.setText(mailCreatorService.buildEmail(mailReservation.getMessage(),
                    mailReservation.getReceiverName(), mailReservation.getReceiverSurname(),
                    mailReservation.getDone(), mailReservation.getStart(), mailReservation.getEnd()), true);
        };
    }
}
