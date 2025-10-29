package com.fraud.microservices.service;

import com.fraud.microservices.dto.CustomerRequest;
import com.fraud.microservices.dto.FraudCheckResponse;
import com.fraud.microservices.mapper.CustomerMapper;
import com.fraud.microservices.model.Customer;
import com.fraud.microservices.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Autowired
    private WebClient.Builder webClientBuilder;


    public CustomerRequest addCustomer(CustomerRequest customerRequest){

        Customer customer = customerMapper.toEntity(customerRequest);

        Customer savedCustomer = customerRepository.saveAndFlush(customer);


        // todo: check if email is valid
        // todo: check if email not taken



        // check if fraudster.

        FraudCheckResponse response = webClientBuilder.build()
                .get()
                    .uri("http://fraud/api/v1/fraud-check/{customerId}", customer.getId())
                        .retrieve()
                            .bodyToMono(FraudCheckResponse.class)
                                .block();


        //todo: send notification
        return customerMapper.toDto(savedCustomer);

    }

}
