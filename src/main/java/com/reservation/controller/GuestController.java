package com.reservation.controller;

import com.reservation.dto.GuestDto;
import com.reservation.mapper.GuestMapper;
import com.reservation.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private GuestMapper guestMapper;
}
