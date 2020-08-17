package com.reservation.mapper;

import com.reservation.domain.Guest;
import com.reservation.dto.GuestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GuestMapper {

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private RestaurantMapper restaurantMapper;

    public Guest mapToGuest(GuestDto guestDto) {
        return new Guest(
                guestDto.getId(),
                guestDto.getUserId(),
                guestDto.getName(),
                guestDto.getSurname(),
                guestDto.getUsername(),
                guestDto.getEmail(),
                guestDto.getPassword(),
                guestDto.getLastLoginDate(),
                guestDto.getLastLoginDateDisplay(),
                guestDto.getJoinDate(),
                guestDto.isActive(),
                guestDto.isNonLocked(),
                guestDto.getAuthorities(),
                guestDto.getRole(),
                guestDto.getProfileImageUrl(),
                reservationMapper.mapToReservationList(guestDto.getReservationDtoList()),
                restaurantMapper.mapToListRestaurant(guestDto.getRestaurantDtoList()));
    }

    public GuestDto mapToGuestDto(Guest guest) {
        return new GuestDto(
                guest.getId(),
                guest.getUserId(),
                guest.getName(),
                guest.getSurname(),
                guest.getUsername(),
                guest.getEmail(),
                guest.getPassword(),
                guest.getLastLoginDate(),
                guest.getLastLoginDateDisplay(),
                guest.getJoinDate(),
                guest.isActive(),
                guest.isNonLocked(),
                guest.getAuthorities(),
                guest.getRole(),
                guest.getProfileImageUrl(),
                reservationMapper.mapToReservationDtoList(guest.getReservationList()),
                restaurantMapper.mapToListRestaurantDto(guest.getRestaurantList()));
    }

    public List<Guest> mapToGuestList(List<GuestDto> guestDtoList) {
        return guestDtoList.stream()
                .map(g -> new Guest(
                        g.getId(),
                        g.getUserId(),
                        g.getName(),
                        g.getSurname(),
                        g.getUsername(),
                        g.getEmail(),
                        g.getPassword(),
                        g.getLastLoginDate(),
                        g.getLastLoginDateDisplay(),
                        g.getJoinDate(),
                        g.isActive(),
                        g.isNonLocked(),
                        g.getAuthorities(),
                        g.getRole(),
                        g.getProfileImageUrl(),
                        reservationMapper.mapToReservationList(g.getReservationDtoList()),
                        restaurantMapper.mapToListRestaurant(g.getRestaurantDtoList())
                ))
                .collect(Collectors.toList());
    }

    public List<GuestDto> mapToGuestDtoList(List<Guest> guestList) {
        return guestList.stream()
                .map(g -> new GuestDto(
                        g.getId(),
                        g.getUserId(),
                        g.getName(),
                        g.getSurname(),
                        g.getUsername(),
                        g.getEmail(),
                        g.getPassword(),
                        g.getLastLoginDate(),
                        g.getLastLoginDateDisplay(),
                        g.getJoinDate(),
                        g.isActive(),
                        g.isNonLocked(),
                        g.getAuthorities(),
                        g.getRole(),
                        g.getProfileImageUrl(),
                        reservationMapper.mapToReservationDtoList(g.getReservationList()),
                        restaurantMapper.mapToListRestaurantDto(g.getRestaurantList())
                ))
                .collect(Collectors.toList());
    }
}