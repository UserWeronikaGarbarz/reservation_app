package com.reservation.controller;

import com.reservation.mapper.GuestMapper;
import com.reservation.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private GuestMapper guestMapper;
}
