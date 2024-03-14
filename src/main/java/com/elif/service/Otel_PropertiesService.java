package com.elif.service;

import com.elif.domain.OtelProperties;
import com.elif.repository.Otel_PropertiesRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class Otel_PropertiesService extends ServiceManager<OtelProperties,String> {
    private final Otel_PropertiesRepository repository;
    public Otel_PropertiesService(Otel_PropertiesRepository repository) {
        super(repository);
        this.repository = repository;

    }
}
