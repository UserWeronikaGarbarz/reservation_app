package com.reservation.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TABLES")
public class TableS {
    private Long id;
    private int tableNumber;
    private int seatsQuantity;
    private Long restaurantId;
    private List<Reservation> reservations = new ArrayList<>();

    public TableS(final int tableNumber, final int seatsQuantity, final Long id) {
        this.tableNumber = tableNumber;
        this.seatsQuantity = seatsQuantity;
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "TABLE_ID", unique = true)
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

    @Column(name = "RESTAURANT_ID")
    public Long getRestaurantId() {
        return restaurantId;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "tableS")
    public List<Reservation> getReservations() {
        return reservations;
    }
}