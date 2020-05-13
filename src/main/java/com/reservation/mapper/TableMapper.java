package com.reservation.mapper;

import com.reservation.domain.TableS;
import com.reservation.dto.TableDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TableMapper {
    public TableS mapToTable(final TableDto tableDto) {
        return new TableS(
                tableDto.getId(),
                tableDto.getTableNumber(),
                tableDto.getSeatsQuantity()
        );
    }

    public TableDto mapToTableDto(final TableS tableS) {
        return new TableDto(
                tableS.getId(),
                tableS.getTableNumber(),
                tableS.getSeatsQuantity()
        );
    }

    public List<TableDto> mapToTableDtoList(final List<TableS> tableSList) {
        return tableSList.stream()
                .map(t -> new TableDto(t.getId(), t.getTableNumber(), t.getSeatsQuantity()))
                .collect(Collectors.toList());
    }
}
