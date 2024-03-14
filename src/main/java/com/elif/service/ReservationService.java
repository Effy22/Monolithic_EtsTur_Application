package com.elif.service;

import com.elif.domain.Reservation;
import com.elif.repository.ReservationRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ReservationService extends ServiceManager<Reservation,String> {
    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
