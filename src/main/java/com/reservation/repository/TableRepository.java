package com.reservation.repository;

import com.reservation.domain.TableS;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface TableRepository extends CrudRepository<TableS, Long> {

    @Override
    List<TableS> findAll();

    @Override
    Optional<TableS> findById(Long id);

    @Override
    TableS save(TableS tableS);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}