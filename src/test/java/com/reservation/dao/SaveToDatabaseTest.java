package com.reservation.dao;

import com.reservation.domain.Reservation;
import com.reservation.domain.TableS;
import com.reservation.repository.ReservationRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaveToDatabaseTest {

    @Autowired
    ReservationRepository reservationRepository;

    @Test
    public void shouldSaveToDatabase() {
        //Given
        TableS tableS1 = new TableS(70L,7, 6);
        TableS tableS2 = new TableS(80L,8, 6);

        LocalDateTime start = LocalDateTime.of(2020, Month.MAY, 28, 14, 33);
        LocalDateTime end = LocalDateTime.of(2019, Month.MAY, 28, 16, 33);

        Reservation reservation = new Reservation(90L,"test", "test",
                "test", start, end, LocalDate.now());

        tableS1.setReservation(reservation);
        tableS2.setReservation(reservation);

        reservation.getTableS().add(tableS1);
        reservation.getTableS().add(tableS2);
        reservationRepository.save(reservation);
        String result = reservation.getName();

        Assert.assertEquals("test", result);
    }
}