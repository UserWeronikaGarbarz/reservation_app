package com.reservation.mapper;

import com.reservation.domain.Guest;
import com.reservation.dto.GuestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuestMapper {

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private RestaurantMapper restaurantMapper;

//    public Guest mapToGuest(GuestDto guestDto) {
//        return new Guest(
//                guestDto.getId(),
//                guestDto.getEmail(),
//                guestDto.getName(),
//                guestDto.getSurname(),
//                guestDto.getPassword(),
//                reservationMapper.mapToReservationList(guestDto.getReservationList()),
//                restaurantMapper.mapToRestaurant(guestDto.getRestaurantDtoList())
//        );
//    }

//    public GuestDto mapToGuestDto(Guest guest) {
//        return new GuestDto(
//                guest.getId(),
//                guest.getName(),
//                guest.getSurname(),
//                guest.getEmail(),
//                guest.getPassword(),
//                reservationMapper.mapToReservationDtoList(guest.getReservationList())
//        );
//    }
}
