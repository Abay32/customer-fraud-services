package com.fraud.microservices.service;

import com.fraud.microservices.model.FraudCheckHistory;
import com.fraud.microservices.repository.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudRepository;

    public boolean isFraudulentCustomer(Integer customerId){

        fraudRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        return false;
    }

}
