package ania.miklash.pjatk.FinalProject.service;

import ania.miklash.pjatk.FinalProject.model.dto.ItemDTO;
import ania.miklash.pjatk.FinalProject.repository.ItemRepository;
import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    public ImmutableList<ItemDTO> getAllItems() {
        final List<ItemDTO> itemsList = repository.findAll();
        return ImmutableList.copyOf(itemsList);
    }

    public void addItem(ItemDTO item) {
        repository.save(item);
    }
}
