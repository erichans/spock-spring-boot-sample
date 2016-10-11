package br.gov.tcu.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.tcu.domain.Customer;

@RestController
public class CustomerService {

    @GetMapping("/something")
    public Customer getSomething() {
        return new Customer("Somebody");
    }

}
