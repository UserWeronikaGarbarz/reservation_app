package com.reservation.controller;

import com.reservation.dto.TableDto;
import com.reservation.exception.TableNotFoundException;
import com.reservation.mapper.TableMapper;
import com.reservation.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/table")
public class TableController {

    @Autowired
    private TableService tableService;

    @Autowired
    private TableMapper tableMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/get/{tableId}")
    public TableDto getTable(@PathVariable Long tableId) throws TableNotFoundException {
        return tableMapper.mapToTableDto(tableService.getTableById(tableId).orElseThrow(TableNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TableDto createTable(@RequestBody TableDto tableDto) {
        return tableMapper.mapToTableDto(tableService.saveTable(tableMapper.mapToTable(tableDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getall")
    public List<TableDto> getAllTables() {
        return tableMapper.mapToTableDtoList(tableService.getAllTables());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{tableId}")
    public void deleteTable(@PathVariable Long tableId) {
        tableService.deleteTable(tableId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public TableDto updateTable(@RequestBody TableDto tableDto) {
        return tableMapper.mapToTableDto(tableService.saveTable(tableMapper.mapToTable(tableDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getavailable")
    public List<TableDto> getFreeTables() {
        return tableMapper.mapToTableDtoList(tableService.findFreeTables());
    }
}