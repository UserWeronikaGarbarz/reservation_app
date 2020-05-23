package com.reservation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TableDto {
    private Long id;
    private int tableNumber;
    private int seatsQuantity;

    public TableDto(final int tableNumber, final int seatsQuantity, final Long id) {
        this.tableNumber = tableNumber;
        this.seatsQuantity = seatsQuantity;
        this.id = id;
    }
}