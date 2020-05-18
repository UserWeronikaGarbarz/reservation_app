package com.reservation.service;

import com.reservation.domain.TableS;
import com.reservation.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {
    @Autowired
    private TableRepository tableRepository;

    public List<TableS> getAllTables() {
        return tableRepository.findAll();
    }

    public Optional<TableS> getTableById(final Long id) {
        return tableRepository.findById(id);
    }

    public TableS saveTable(final TableS tableS) {
        return tableRepository.save(tableS);
    }

    public void deleteTable(final Long id) {
        tableRepository.deleteById(id);
    }

    public List<TableS> findFreeTables() {
        return tableRepository.findTableS();
    }
}