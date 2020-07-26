package com.reservation.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@Setter
@Entity
@Table(name = "RESERVATION")
public class Reservation {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDateTime startOfReservation;
    private LocalDateTime endOfReservation;
    private List<TableS> tableS = new ArrayList<>();
    private LocalDate reservationDone = LocalDate.now();
    private Long restaurantId;
    private Guest guest;

    public Reservation(final String name, final String surname,
                       final String email, final LocalDateTime startOfReservation,
                       final LocalDateTime endOfReservation, final List<TableS> tableS, final Long restaurantId) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.startOfReservation = startOfReservation;
        this.endOfReservation = endOfReservation;
        this.tableS = tableS;
        this.restaurantId = restaurantId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "RESERVATION_ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @Column(name = "START_RESERVATION")
    public LocalDateTime getStartOfReservation() {
        return startOfReservation;
    }

    @Column(name = "END_RESERVATION")
    public LocalDateTime getEndOfReservation() {
        return endOfReservation;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_TABLES_RESERVAION",
            joinColumns = {@JoinColumn(name = "RESERVATION_ID", referencedColumnName = "RESERVATION_ID")},
            inverseJoinColumns = {@JoinColumn(name = "TABLE_ID", referencedColumnName = "TABLE_ID")}
    )
    public List<TableS> getTableS() {
        return tableS;
    }

    @Column(name = "RESERVATION_DONE")
    public LocalDate getReservationDone() {
        return reservationDone;
    }

    @Column(name = "RESTAURANT_ID")
    public Long getRestaurantId() {
        return restaurantId;
    }

    @ManyToOne
    @JoinColumn(name = "GUEST_ID")
    public Guest getGuest() {
        return guest;
    }
}