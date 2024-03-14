package com.elif.service;

import com.elif.domain.Otel_Room;
import com.elif.repository.Otel_RoomRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class Otel_RoomService extends ServiceManager<Otel_Room,String> {
    private final Otel_RoomRepository repository;
    public Otel_RoomService(Otel_RoomRepository repository) {
        super(repository);
        this.repository = repository;

    }
}
