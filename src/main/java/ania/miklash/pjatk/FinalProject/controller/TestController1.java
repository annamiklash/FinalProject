package ania.miklash.pjatk.FinalProject.controller;

import ania.miklash.pjatk.FinalProject.common.Properties;
import ania.miklash.pjatk.FinalProject.mapper.CustomerMapper;
import ania.miklash.pjatk.FinalProject.model.dto.CustomerDTO;
import ania.miklash.pjatk.FinalProject.model.request.NewCustomerRequest;
import ania.miklash.pjatk.FinalProject.model.response.NewCustomerResponse;
import ania.miklash.pjatk.FinalProject.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/customer")
@Validated
public class TestController1 {

    private final CustomerService customerService;

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewCustomerResponse> addCustomer(@Valid @RequestBody NewCustomerRequest customerRequest) {
        final NewCustomerResponse newCustomerResponse = customerService.saveCustomer(customerRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomerResponse);

    }
}

