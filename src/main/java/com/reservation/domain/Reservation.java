package com.reservation.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@NoArgsConstructor
@Setter
@Entity(name = "RESERVATION")
public class Reservation {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDateTime dateOfReservation;
    private List<TableS> tables = new ArrayList<>();
    private Date reservationDone;

    public Reservation(final Long id, final String name, final String surname,
                       final String email, final LocalDateTime dateOfReservation,
                       final List<TableS> tables, final Date reservationDone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfReservation = dateOfReservation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
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

    @Column(name = "DATE_OF_RESERVATION")
    public LocalDateTime getDateOfReservation() {
        return dateOfReservation;
    }

    @OneToMany(
            targetEntity = TableS.class,
            mappedBy = "reservation",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<TableS> getTables() {
        return tables;
    }

    @Column(name = "RESERVATION_DONE")
    public Date getReservationDone() {
        return reservationDone;
    }
}