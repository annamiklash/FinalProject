package ania.miklash.pjatk.FinalProject.controller

import ania.miklash.pjatk.FinalProject.model.dto.MenuDTO
import ania.miklash.pjatk.FinalProject.service.MenuService
import com.google.common.collect.ImmutableList
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import javax.validation.ConstraintViolationException

import static org.hamcrest.Matchers.hasSize
import static org.hamcrest.Matchers.is
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(controllers = [MenuController.class])
class MenuControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @MockBean
    private MenuService menuService

    def "GET /api/menu returns 1 menu postive test scenario"() {
        given:
        def menu = MenuDTO.builder()
                .id(1L)
                .name("SAMPLE MENU NAME")
                .build()

        BDDMockito.given(menuService.getAllMenus())
                .willReturn(ImmutableList.of(menu))

        expect:
        mockMvc.perform(
                get("/api/menu/{menuName}", "sample menu name")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("\$", hasSize(1)))
                .andExpect(jsonPath("\$[0].id", is(1)))
                .andExpect(jsonPath("\$[0].name", is("SAMPLE MENU NAME")))
    }

    def "GET /api/menu"() {
        given:
        BDDMockito.given(menuService.getAllMenus())
                .willThrow(ConstraintViolationException.class)

        expect:
        mockMvc.perform(
                get("/api/menu/{menuName}", "sample menu name")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andExpect(status().isBadRequest())
    }
}
