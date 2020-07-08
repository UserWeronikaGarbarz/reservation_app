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
@Table(name = "login")
public class Login {
    private String email;
    private String password;
    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }
}
