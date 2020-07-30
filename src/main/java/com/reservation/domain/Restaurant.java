package com.reservation.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@NoArgsConstructor
@Setter
@Entity
@Table(name = "RESTAURANT")
public class Restaurant {
    private int id;
    private String name;
    private String username;
    private String street;
    private int number;
    private String code;
    private String email;
    private String password;
    private List<TableS> tables = new ArrayList<>();
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;
    private boolean isActive;
    private List<Reservation> reservations = new ArrayList<>();
    private List<Guest> guests = new ArrayList<>();


    public Restaurant(int id, String name, String username, String street, int number, String code,
                      String email, String password, List<TableS> tableS,
                      Date lastLoginDate, Date lastLoginDateDisplay, Date joinDate, List<Reservation> reservations,
                      List<Guest> guests) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.street = street;
        this.number = number;
        this.code = code;
        this.email = email;
        this.password = password;
        this.tables = tableS;
        this.lastLoginDate = lastLoginDate;
        this.lastLoginDateDisplay = lastLoginDateDisplay;
        this.joinDate = joinDate;
        this.reservations = reservations;
        this.guests = guests;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "RESTAURANT_ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    @Column(name = "NUMBER")
    public int getNumber() {
        return number;
    }

    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @Column(name = "PASSWORD")
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

    @Column(name="USERNAME")
    public String getUsername() {
        return username;
    }

    @Column(name="LAST_LOGIN_DATE")
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    @Column(name="LAST_LOGIN_DATE_DISPLAYED")
    public Date getLastLoginDateDisplay() {
        return lastLoginDateDisplay;
    }

    @Column(name="JOIN_DATE")
    public Date getJoinDate() {
        return joinDate;
    }

    @Column(name="IS_ACTIVE")
    public boolean isActive() {
        return isActive;
    }
}
