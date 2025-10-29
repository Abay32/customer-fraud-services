package com.fraud.microservices.controller;

import com.fraud.microservices.dto.CustomerRequest;
import com.fraud.microservices.model.Customer;
import com.fraud.microservices.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerRequest> registerCustomer(@RequestBody CustomerRequest customerRequest){
            return new  ResponseEntity<>( customerService.addCustomer(customerRequest), HttpStatus.CREATED);
    }

}
