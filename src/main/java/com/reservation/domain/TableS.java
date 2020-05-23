package com.reservation.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Component
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TABLES")
public class TableS {
    private Long id;
    private int tableNumber;
    private int seatsQuantity;
    private Long reservationId;

    public TableS(final int tableNumber, final int seatsQuantity, final Long id) {
        this.tableNumber = tableNumber;
        this.seatsQuantity = seatsQuantity;
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "TABLE_NUMBER")
    public int getTableNumber() {
        return tableNumber;
    }

    @Column(name = "SEATS_QUANTITY")
    public int getSeatsQuantity() {
        return seatsQuantity;
    }

    @Column(name = "RESERVATION_ID")
    public Long getReservationId() {
        return reservationId;
    }
}