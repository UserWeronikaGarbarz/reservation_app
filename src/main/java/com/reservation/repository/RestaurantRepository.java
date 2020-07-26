package com.reservation.repository;

import com.reservation.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    @Override
    List<Restaurant> findAll();

    @Override
    long count();

    @Override
    Restaurant save(Restaurant restaurant);

    @Override
    void deleteById(Long id);
}
