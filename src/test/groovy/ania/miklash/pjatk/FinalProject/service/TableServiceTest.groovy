package ania.miklash.pjatk.FinalProject.service

import ania.miklash.pjatk.FinalProject.model.dto.CustomerDTO
import ania.miklash.pjatk.FinalProject.model.dto.TableDTO
import ania.miklash.pjatk.FinalProject.repository.TableRepository
import com.google.common.collect.ImmutableList
import spock.lang.Specification
import spock.lang.Subject

class TableServiceTest extends Specification {

    @Subject
    TableService tableService

    TableRepository tableRepository

    def setup() {
        tableRepository = Mock()

        tableService = new TableService(tableRepository)
    }

    def "addTable positive test scenario"() {
        given:
        def table = TableDTO.builder()
                .id(1)
                .tableNumber(3)
                .maxGuestsNumber(4)
                .build()

        when:
        tableService.addTable(table)

        then:
        1 * tableRepository.save(table)
    }

    def "getAllTables positive test scenario"() {
        given:
        def table = TableDTO.builder()
                .id(1)
                .tableNumber(3)
                .maxGuestsNumber(4)
                .build()

        def tableList = Arrays.asList(table)

        def target = ImmutableList.copyOf(tableList)

        when:
        def result = tableService.getAllTables()

        then:
        result == target

        1 * tableRepository.findAll() >> tableList
    }
}
