package ania.miklash.pjatk.FinalProject.service;

import ania.miklash.pjatk.FinalProject.model.dto.CustomerDTO;
import ania.miklash.pjatk.FinalProject.repository.CustomerRepository;
import com.google.common.collect.ImmutableList;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public ImmutableList<CustomerDTO> getAllCustomers() {
        final var customersList = ImmutableList.copyOf(repository.findAll());

        log.info(customersList.toString());

        return customersList;
    }

    public void saveCustomer(CustomerDTO customerDTO) {
        repository.save(customerDTO);
    }
}
