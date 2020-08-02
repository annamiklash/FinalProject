package ania.miklash.pjatk.FinalProject.service

import ania.miklash.pjatk.FinalProject.model.dto.CustomerDTO
import ania.miklash.pjatk.FinalProject.repository.CustomerRepository
import spock.lang.Specification
import spock.lang.Subject

class CustomerServiceTest extends Specification {

    @Subject
    CustomerService customerService

    CustomerRepository repository

    def setup() {
        repository = Mock()

        customerService = new CustomerService(repository)
    }

    def "saveCustomer positive test scenario"() {
        given:
        def customerDTO = CustomerDTO.builder().id(1).name("Ania").build()

        when:
        customerService.saveCustomer(customerDTO)

        then:
        1 * repository.save(customerDTO)
    }


}
