package com.elif.service;

import com.elif.domain.Otel_Image;
import com.elif.repository.Otel_ImageRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class Otel_ImageService extends ServiceManager<Otel_Image,String> {
    private final Otel_ImageRepository repository;
    public Otel_ImageService(Otel_ImageRepository repository) {
        super(repository);
        this.repository = repository;

    }
}
