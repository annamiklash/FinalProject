package ania.miklash.pjatk.FinalProject.service;

import ania.miklash.pjatk.FinalProject.model.dto.MenuDTO;
import ania.miklash.pjatk.FinalProject.repository.MenuRepository;
import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class MenuService {
    private final MenuRepository repository;

    public ImmutableList<MenuDTO> getAllMenus() {
        final List<MenuDTO> menuList = repository.findAll();

        log.info("menuList size is " + menuList.size());

        return ImmutableList.copyOf(menuList);
    }

    public void addMenu(MenuDTO menu) {
        repository.save(menu);
    }
}
