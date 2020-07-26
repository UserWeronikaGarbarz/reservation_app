package com.reservation.service;

import com.reservation.domain.Guest;
import com.reservation.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }
}
