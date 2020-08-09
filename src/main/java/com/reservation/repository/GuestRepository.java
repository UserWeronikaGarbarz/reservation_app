package com.reservation.repository;

import com.reservation.domain.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuestRepository extends CrudRepository<Guest, Long> {


    @Override
    List<Guest> findAll();

    @Override
    Guest save(Guest guest);

    Guest findGuestByUsername(String username);

    Guest findGuestByEmail(String email);
}
