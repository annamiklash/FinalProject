package ania.miklash.pjatk.FinalProject.service;

import ania.miklash.pjatk.FinalProject.mapper.CustomerMapper;
import ania.miklash.pjatk.FinalProject.model.dto.CustomerDTO;
import ania.miklash.pjatk.FinalProject.model.request.NewCustomerRequest;
import ania.miklash.pjatk.FinalProject.model.response.NewCustomerResponse;
import ania.miklash.pjatk.FinalProject.repository.CustomerRepository;
import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper customerMapper;

    public ImmutableList<CustomerDTO> getAllCustomers() {
        final var customersList = ImmutableList.copyOf(repository.findAll());

        log.info(customersList.toString());

        return customersList;
    }

    public NewCustomerResponse saveCustomer(NewCustomerRequest customerRequest) {
        final CustomerDTO customerDTO = customerMapper.mapToDTO(customerRequest);
        log.info("trying to save " + customerDTO.toString());
        repository.save(customerDTO);
        final NewCustomerResponse customerResponse = customerMapper.mapToResponse(customerDTO);

        return customerResponse;
    }

    public CustomerDTO findCustomerById(long customerId) {
        final Optional<CustomerDTO> optionalCustomer = repository.findById(customerId);

        if (optionalCustomer.isEmpty()) {
            throw new IllegalArgumentException("Customer with id " + customerId + " DOESNT EXIST");
        }
        return optionalCustomer.get();

    }
}
