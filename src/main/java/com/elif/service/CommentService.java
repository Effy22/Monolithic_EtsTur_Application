package com.elif.service;

import com.elif.domain.Comment;
import com.elif.repository.CommentRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService extends ServiceManager<Comment,String> {
    private final CommentRepository repository;
    public CommentService(CommentRepository repository) {
        super(repository);
        this.repository = repository;

    }

    public List<Comment> findByOtelId(String otelId) {
        return repository.findByOtelId(otelId);
    }
}
