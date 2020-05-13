package com.reservation.controller;

import com.reservation.domain.TableS;
import com.reservation.dto.TableDto;
import com.reservation.mapper.TableMapper;
import com.reservation.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class TableController {

    @Autowired
    private TableService tableService;

    @Autowired
    private TableMapper tableMapper;

    @RequestMapping(method = RequestMethod.GET, value = "tables/{tableId}")
    public TableDto getTable(@PathVariable Long tableId) throws TableNotFoundException {
        return tableMapper.mapToTableDto(tableService.getTableById(tableId).orElseThrow(TableNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tables", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TableS createTable(@RequestBody TableDto tableDto) {
        return tableService.saveTable(tableMapper.mapToTable(tableDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tables")
    public List<TableDto> getAllTables() {
        return tableMapper.mapToTableDtoList(tableService.getAllTables());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "tables/{tableId}")
    public void deleteTable(@PathVariable Long tableId) {
        tableService.deleteTable(tableId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/tasks")
    public TableDto updateTable(@RequestBody TableDto tableDto) {
        return tableMapper.mapToTableDto(tableService.saveTable(tableMapper.mapToTable(tableDto)));
    }
}