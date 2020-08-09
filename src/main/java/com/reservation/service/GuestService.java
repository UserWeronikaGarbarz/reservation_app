package com.reservation.service;

import com.reservation.domain.Guest;
import com.reservation.domain.MailRegistration;
import com.reservation.dto.GuestDto;
import com.reservation.exception.EmailExistsException;
import com.reservation.exception.GuestNotFoundException;
import com.reservation.exception.UsernameExistsException;
import com.reservation.mapper.GuestMapper;
import com.reservation.repository.GuestRepository;
import com.reservation.security.configuration.SecurityConstant;
import com.reservation.security.enumeration.Role;
import com.reservation.security.jwt.JWTTokenProvider;
import com.reservation.security.service.GuestAutentication;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Qualifier("userDetailsService")
public class GuestService implements UserDetailsService {
    private Logger LOGGER = LoggerFactory.getLogger(GuestService.class);

    @Autowired
    private GuestMapper guestMapper;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JWTTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Autowired
    private MailService mailService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Guest guest = guestRepository.findGuestByUsername(username);
        if (guest == null) {
            LOGGER.error("User not found by: " + username);

            throw new UsernameNotFoundException("User not found by: " + username);
        } else {
            validateLoginAttepmt(guest);
            guest.setLastLoginDateDisplay(guest.getLastLoginDate());
            guest.setLastLoginDate(new Date());
            guestRepository.save(guest);
            GuestAutentication guestAutentication = new GuestAutentication(guest);
            LOGGER.info("Returning found user by username: " + username);
            return guestAutentication;
        }
    }

    private void validateLoginAttepmt(Guest guest) {
        if (guest.isNonLocked()) {
            if (loginAttemptService.exceedMaxAttempts(guest.getUsername())) {
                guest.setNonLocked(false);
            } else {
                guest.setNonLocked(true);
            }
        } else {
            loginAttemptService.removeUserFromCache(guest.getUsername());
        }
    }
    String password = generatePassword();
    public Guest register(String firstName, String lastName, String username, String email)
            throws UsernameExistsException, EmailExistsException, GuestNotFoundException {
        validateNewUsernameAndEmail(StringUtils.EMPTY, username, email);
        GuestDto guestDto = new GuestDto();
        guestDto.setUserId(generateUserId());
        String encodedPassword = encodePassword(password);
        guestDto.setName(firstName);
        guestDto.setSurname(lastName);
        guestDto.setUsername(username);
        guestDto.setEmail(email);
        guestDto.setJoinDate(new Date());
        guestDto.setPassword(encodedPassword);
        guestDto.setActive(true);
        guestDto.setNonLocked(true);
        guestDto.setAuthorities(Role.ROLE_GUEST.getAuthorities());
        guestDto.setRole(Role.ROLE_GUEST.name());

        Guest guestRegistered = guestRepository.save(guestMapper.mapToGuest(guestDto));
        sendEmail(guestRegistered);

        return guestRegistered;
    }

    public void sendEmail(Guest guest) {
        mailService.send(new MailRegistration(guest.getEmail(),"New account in Restaurant-app", "Your account has been created",
                guest.getName(), guest.getSurname(), password,
                guest.getUsername()));
    }

    private String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    private String generateUserId() {
        return RandomStringUtils.randomNumeric(10);
    }

    private void validateNewUsernameAndEmail(String currentUsername, String newUsername, String newEmail)
            throws GuestNotFoundException, EmailExistsException, UsernameExistsException {

        Guest byEmail = findGuestByEmail(newEmail);
        Guest byUsername = findGuestByUsername(newUsername);

        if (StringUtils.isNotBlank(currentUsername)) {
            Guest currentGuest = findGuestByUsername(currentUsername);
            if (currentGuest == null) {
                throw new GuestNotFoundException("No guest found by username " + currentUsername);
            }
            if (byUsername != null && !currentGuest.getUserId().equals(byUsername.getUserId())) {
                throw new UsernameExistsException("Username already exists");
            }
            if (byEmail != null && !currentGuest.getUserId().equals(byEmail.getUserId())) {
                throw new EmailExistsException("Email already exists");
            }
        } else {
            if (byUsername != null) {
                throw new UsernameExistsException("Username already exists");
            }
            if (byEmail != null) {
                throw new EmailExistsException("Email already exists");
            }
        }
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest findGuestByUsername(String username) {
        return guestRepository.findGuestByUsername(username);
    }


    public Guest findGuestByEmail(String email) {
        return guestRepository.findGuestByEmail(email);
    }

    public HttpHeaders getJwtHeader(Guest guest) {
        GuestAutentication guestAutentication = new GuestAutentication(guest);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(SecurityConstant.JWT_TOKEN_HEADER, jwtTokenProvider.generateJWTToken(guestAutentication));
        return httpHeaders;
    }

    public void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}