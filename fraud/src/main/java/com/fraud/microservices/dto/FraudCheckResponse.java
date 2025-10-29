package com.fraud.microservices.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FraudCheckResponse {
    private boolean isFraudster;
    private String comment;
}
