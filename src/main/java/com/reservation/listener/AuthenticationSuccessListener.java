package com.reservation.listener;

import com.reservation.domain.Guest;
import com.reservation.service.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessListener {

    @Autowired
    private LoginAttemptService loginAttemptService;

    @EventListener
    public void onAuthenticationSuccess(AuthenticationSuccessEvent event) {
        Object principal = event.getAuthentication().getPrincipal();
        if (principal instanceof Guest) {
            Guest guest = (Guest) event.getAuthentication().getPrincipal();
            loginAttemptService.removeUserFromCache(guest.getUsername());
        }
    }
}
