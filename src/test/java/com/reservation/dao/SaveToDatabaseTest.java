package com.reservation.dao;

import com.reservation.domain.Reservation;
import com.reservation.domain.TableS;
import org.junit.Test;

public class SaveToDatabaseTest {

    @Test
    public void shouldSaveToDatabase() {
        //Given
        TableS tableS1 = new TableS(1L, 1,3, new Reservation());
    }
}
