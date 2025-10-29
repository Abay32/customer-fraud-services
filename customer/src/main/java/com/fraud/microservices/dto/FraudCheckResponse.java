package com.fraud.microservices.dto;


import lombok.*;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

public class FraudCheckResponse {
    private boolean isFraudster;
    private String comment;
}
