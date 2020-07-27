package com.reservation.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@Setter
@Entity
@Table(name = "Restaurant")
public class Restaurant {
    private int id;
    private String name;
    private String street;
    private int number;
    private String code;
    private String email;
    private String password;
    private List<TableS> tables;
    private List<Reservation> reservations = new ArrayList<>();
    private List<Guest> guests = new ArrayList<>();

    public Restaurant(int id, String name, String street, int number, String code, String email, String password, List<TableS> tableS) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.number = number;
        this.code = code;
        this.email = email;
        this.password = password;
        this.tables = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "RESTAURANT_ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    @Column(name = "code")
    public String getCode() {
        return code;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @OneToMany(
            targetEntity = TableS.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "RESTAURANT_ID")
    public List<TableS> getTables() {
        return tables;
    }

    @OneToMany(
            targetEntity = Reservation.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "RESTAURANT_ID")
    public List<Reservation> getReservations() {
        return reservations;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "restaurantList")
    public List<Guest> getGuests() {
        return guests;
    }
}
