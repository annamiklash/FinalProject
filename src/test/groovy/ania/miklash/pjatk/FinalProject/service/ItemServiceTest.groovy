package ania.miklash.pjatk.FinalProject.service


import ania.miklash.pjatk.FinalProject.model.dto.ItemDTO
import ania.miklash.pjatk.FinalProject.repository.ItemRepository
import com.google.common.collect.ImmutableList
import spock.lang.Specification
import spock.lang.Subject

class ItemServiceTest extends Specification {

    @Subject
    ItemService itemService

    ItemRepository repository

    def setup() {
        repository = Mock()

        itemService = new ItemService(repository)
    }

    def "addItem positive test scenario"() {
        given:
        def itemDTO = ItemDTO.builder().id(1)
                .name("name")
                .description("description")
                .price(new BigDecimal(25.99))
                .build()

        when:
        itemService.addItem(itemDTO)

        then:
        1 * repository.save(itemDTO)
    }

    def "getAllItems positive test scenario"() {
        given:
        def item1 = ItemDTO.builder()
                .id(1)
                .name("name")
                .description("description")
                .price(new BigDecimal(25.99))
                .build()

        def item2 = ItemDTO.builder()
                .id(2)
                .name("name")
                .description("description")
                .price(new BigDecimal(20.99))
                .build()

        def itemsList = [item1, item2]

        def target = ImmutableList.copyOf(itemsList)
        when:
        def result = itemService.getAllItems()

        then:
        1 * repository.findAll() >> itemsList

        result == target
    }

}
