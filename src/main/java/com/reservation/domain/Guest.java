package com.reservation.domain;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Setter
@Entity
@Table(name = "GUEST")
public class Guest {
    private int id;
    private String userId;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;
    private boolean isActive;
    private List<Reservation> reservationList = new ArrayList<>();
    private List<Restaurant> restaurantList = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "GUEST_ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    @OneToMany(
            targetEntity = Reservation.class,
            mappedBy = "guest",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_GUESTS_RESTAURANTS",
            joinColumns = {@JoinColumn(name = "GUEST_ID", referencedColumnName = "GUEST_ID")},
            inverseJoinColumns = {@JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "RESTAURANT_ID")}
    )
    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    @Column(name="USER_ID")
    public String getUserId() {
        return userId;
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
