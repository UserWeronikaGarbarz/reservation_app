package com.reservation.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Component
@NoArgsConstructor
@Setter
@Entity
@Table(name = "signup")
public class SignUp {
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean admin;
    private int id;

    @Column(name="name")
    public String getName() {
        return name;
    }

    @Column(name="surname")
    public String getSurname() {
        return surname;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }

    @Column(name="admin")
    public boolean isAdmin() {
        return admin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }
}
