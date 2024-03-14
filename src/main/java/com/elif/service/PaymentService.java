package com.elif.service;

import com.elif.domain.Payment;
import com.elif.repository.PaymentRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class PaymentService extends ServiceManager<Payment,String> {
    private final PaymentRepository repository;
    public PaymentService(PaymentRepository repository) {
        super(repository);
        this.repository = repository;

    }
}
