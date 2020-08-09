package ania.miklash.pjatk.FinalProject.controller;

import ania.miklash.pjatk.FinalProject.model.dto.MenuDTO;
import ania.miklash.pjatk.FinalProject.service.MenuService;
import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@Validated
@RestController
@RequestMapping("api/menu")
public class MenuController {

    private final MenuService menuService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{menuName}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImmutableList<MenuDTO>> getMenu(@PathVariable String menuName) {
        log.info("GET " + menuName);
        return ResponseEntity.ok(menuService.getAllMenus());
    }
}
