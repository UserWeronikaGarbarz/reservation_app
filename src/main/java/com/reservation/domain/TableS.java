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
    private Reservation reservation;

    public TableS(final Long id, final int tableNumber, final int seatsQuantity) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.seatsQuantity = seatsQuantity;
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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "RESERVATION_ID")
    public Reservation getReservation() {
        return reservation;
    }
}