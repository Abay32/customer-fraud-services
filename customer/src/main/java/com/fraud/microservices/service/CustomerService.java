package com.fraud.microservices.service;

import com.fraud.microservices.dto.CustomerRequest;
import com.fraud.microservices.mapper.CustomerMapper;
import com.fraud.microservices.model.Customer;
import com.fraud.microservices.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerRequest addCustomer(CustomerRequest customerRequest){

        Customer customer = customerMapper.toEntity(customerRequest);

        Customer savedCustomer = customerRepository.save(customer);


        // todo: check if email is valid
        // todo: check if email not taken
        // todo: check if fraudster.


        //todo: send notification
        return customerMapper.toDto(savedCustomer);

    }

}
