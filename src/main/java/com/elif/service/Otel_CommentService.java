package com.elif.service;

import com.elif.domain.Otel_Comment;
import com.elif.repository.Otel_CommentRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class Otel_CommentService extends ServiceManager<Otel_Comment,String> {
    private final Otel_CommentRepository repository;
    public Otel_CommentService(Otel_CommentRepository repository) {
        super(repository);
        this.repository = repository;

    }
}
