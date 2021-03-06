package com.reservation.repository;

import com.reservation.domain.TableS;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

//    @Query(value = "select * from reservation.tables t where t.RESERVATION_ID is null", nativeQuery = true)
    List<TableS> findTableSByReservationsIsNull();

    @Modifying
    @Query("update TableS set reservations = null where reservations=:reservId")
    void updateTable(@Param("reservId") Long id);

}