package com.reservation.controller;

import com.reservation.domain.Guest;
import com.reservation.dto.GuestDto;
import com.reservation.exception.EmailExistsException;
import com.reservation.exception.GuestNotFoundException;
import com.reservation.exception.UsernameExistsException;
import com.reservation.mapper.GuestMapper;
import com.reservation.exception.ExceptionHandling;
import com.reservation.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class GuestController extends ExceptionHandling {

    @Autowired
    private GuestService guestService;

    @Autowired
    private GuestMapper guestMapper;

    @PostMapping("/guest/register")
    public GuestDto register(@RequestBody GuestDto guestDto) throws UsernameExistsException, GuestNotFoundException, EmailExistsException {
        return guestMapper.mapToGuestDto(guestService.register(guestDto.getName(), guestDto.getSurname(), guestDto.getUsername(), guestDto.getEmail()));
    }

    @PostMapping("/guest/login")
    public ResponseEntity<GuestDto> login(@RequestBody GuestDto guestDto) {
        guestService.authenticate(guestDto.getUsername(), guestDto.getPassword());
        GuestDto loginGuest = guestMapper.mapToGuestDto(guestService.findGuestByUsername(guestDto.getUsername()));
        HttpHeaders jwtHeader = guestService.getJwtHeader(guestMapper.mapToGuest(loginGuest));
        return new ResponseEntity<>(loginGuest, jwtHeader, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/guest/showall")
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }


}
