package com.fraud.microservices.controller;

import com.fraud.microservices.dto.FraudCheckResponse;
import com.fraud.microservices.service.FraudCheckHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@RequiredArgsConstructor
public class FraudCheckHistoryController {

    private final FraudCheckHistoryService fraudService;

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable(name = "customerId") Integer customerId){
        
        boolean fraudster = fraudService.isFraudulentCustomer(customerId);

        System.out.println("FASDFASDFASDFASDF ..........."+ fraudster);

        return FraudCheckResponse.builder()
                .isFraudster(fraudster)
                .comment(  !fraudster ? "This is not fraudulent" : "This is potentially fraudster customer!")
                .build();
    }

}
