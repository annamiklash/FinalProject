package ania.miklash.pjatk.FinalProject.controller;

import ania.miklash.pjatk.FinalProject.common.Properties;
import ania.miklash.pjatk.FinalProject.model.dto.CustomerDTO;
import ania.miklash.pjatk.FinalProject.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class TestController {

    private final Properties properties;
    private final CustomerService customerService;

    @GetMapping("api/test")
    public ResponseEntity<CustomerDTO> getTest() {
        log.info("siemanko");
        log.debug("siemanko");
        log.warn("siemanko");

        CustomerDTO build = CustomerDTO.builder()
                .name("Ania")
                .surname("Miklash")
                .build();

        customerService.saveCustomer(build);

        return ResponseEntity.status(HttpStatus.CREATED).body(build);
    }

    @GetMapping("api/test1")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        log.info("siemanko");

        return ResponseEntity.ok(customerService.getAllCustomers());
    }
}
