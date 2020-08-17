package com.reservation.repository;

import com.reservation.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    @Override
    List<Restaurant> findAll();

    long count();

    @Override
    Restaurant save(Restaurant restaurant);

    void deleteById(int id);

    Restaurant findRestaurantByUsername(String username);

    Restaurant findRestaurantByName(String name);

    Restaurant findRestaurantByEmail(String email);

    Restaurant findRestaurantById(int id);

    @Override
    void deleteById(Long id);

}
