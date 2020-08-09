package ania.miklash.pjatk.FinalProject.service


import ania.miklash.pjatk.FinalProject.model.dto.MenuDTO
import ania.miklash.pjatk.FinalProject.repository.MenuRepository
import com.google.common.collect.ImmutableList
import spock.lang.Specification
import spock.lang.Subject

class MenuServiceTest extends Specification {

    @Subject
    MenuService menuService

    MenuRepository repository

    def setup() {
        repository = Mock()

        menuService = new MenuService(repository)
    }

    def "addMenu positive test scenario"() {
        given:
        def menuDTO = MenuDTO.builder().id(1)
                .name("name")
                .build()

        when:
        menuService.addMenu(menuDTO)

        then:
        1 * repository.save(menuDTO)
    }

    def "getAllMenus positive test scenario"() {
        given:
        def menu = MenuDTO.builder()
                .id(1)
                .name("name")
                .build()


        def menuList = [menu]

        def target = ImmutableList.copyOf(menuList)
        when:
        def result = menuService.getAllMenus()

        then:
        1 * repository.findAll() >> menuList

        result == target
    }
}
