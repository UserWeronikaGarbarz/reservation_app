package com.reservation.service;

import com.reservation.domain.Mail;
import com.reservation.domain.Reservation;
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

    public void send(final Mail mail) {
        LOGGER.info("Starting email preparation...");
        try {
            javaMailSender.send(createMimeMessage(mail));
        } catch (MailException e) {
            LOGGER.error("Failed to process email sending" + e.getMessage(), e);
        }
    }

    private MimeMessagePreparator createMimeMessage(final Mail mail) {
        return mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setTo(mail.getEmail());
            mimeMessageHelper.setSubject(mail.getSubject());
            mimeMessageHelper.setText(mailCreatorService.buildEmail(mail.getMessage(), mail.getReceiverName(),
                    mail.getReceiverSurname(), mail.getDone(), mail.getStart(), mail.getEnd()), true);
        };
    }
}
