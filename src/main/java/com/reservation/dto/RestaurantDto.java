package com.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RestaurantDto {
    private String name;
    private String street;
    private int number;
    private String code;
    private String email;
    private String password;
    private List<TableDto> tables = new ArrayList<>();
}
