package ania.miklash.pjatk.FinalProject.mapper;

import ania.miklash.pjatk.FinalProject.model.dto.CustomerDTO;
import ania.miklash.pjatk.FinalProject.model.request.NewCustomerRequest;
import ania.miklash.pjatk.FinalProject.model.response.NewCustomerResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerMapper {

    public CustomerDTO mapToDTO(NewCustomerRequest customerRequest) {

        final CustomerDTO customer = CustomerDTO.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .phoneNumber(customerRequest.getPhoneNumber())
                .hashedPassword(customerRequest.getPassword())
                .build();

        if (customerRequest.getBirthDate() != null) {
            customer.setBirthDate(LocalDate.parse(customerRequest.getBirthDate()));
        }

        return customer;
    }

    public NewCustomerResponse mapToResponse(CustomerDTO customer) {
        return NewCustomerResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }
}
