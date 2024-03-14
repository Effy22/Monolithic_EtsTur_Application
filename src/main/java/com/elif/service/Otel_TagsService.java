package com.elif.service;

import com.elif.domain.Otel_Tags;
import com.elif.repository.Otel_TagsRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Otel_TagsService extends ServiceManager<Otel_Tags,String> {
    private final Otel_TagsRepository repository;
    public Otel_TagsService(Otel_TagsRepository repository) {
        super(repository);
        this.repository = repository;

    }

    public List<Otel_Tags> findByOtelId(String id) {
        return repository.findByOtelId(id);
    }
}
