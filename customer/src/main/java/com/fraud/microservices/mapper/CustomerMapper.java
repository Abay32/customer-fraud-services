package com.fraud.microservices.mapper;


import com.fraud.microservices.dto.CustomerRequest;
import com.fraud.microservices.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerRequest toDto(Customer customer);
    Customer toEntity(CustomerRequest customerRequest);
}
