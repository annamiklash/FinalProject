package ania.miklash.pjatk.FinalProject.service;

import ania.miklash.pjatk.FinalProject.model.dto.TableDTO;
import ania.miklash.pjatk.FinalProject.repository.TableRepository;
import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TableService {

    private final TableRepository tableRepository;

    public ImmutableList<TableDTO> getAllTables() {
        final List<TableDTO> tablesList = tableRepository.findAll();
        return ImmutableList.copyOf(tablesList);
    }

    public void addTable(TableDTO tableDTO) {
        tableRepository.save(tableDTO);
    }

}
