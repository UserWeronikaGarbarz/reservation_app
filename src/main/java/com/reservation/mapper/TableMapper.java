package com.reservation.mapper;

import com.reservation.domain.TableS;
import com.reservation.dto.TableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TableMapper {

    public TableS mapToTable(final TableDto tableDto) {
        return new TableS(
                tableDto.getTableNumber(),
                tableDto.getSeatsQuantity(),
                tableDto.getId()
        );
    }

    public TableDto mapToTableDto(final TableS tableS) {
        return new TableDto(
                tableS.getTableNumber(),
                tableS.getSeatsQuantity(),
                tableS.getId()
        );
    }

    public List<TableDto> mapToTableDtoList(final List<TableS> tableSList) {
        return tableSList.stream()
                .map(t -> new TableDto(
                        t.getTableNumber(),
                        t.getSeatsQuantity(),
                        t.getId())
                ).collect(Collectors.toList());
    }

    public List<TableS> mapToTableList(final List<TableDto> tableDtoList) {
        return tableDtoList.stream()
                .map(t -> new TableS(
                        t.getTableNumber(),
                        t.getSeatsQuantity(),
                        t.getId())
                ).collect(Collectors.toList());
    }
}