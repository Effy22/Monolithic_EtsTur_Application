package com.elif.repository;

import com.elif.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends MongoRepository<Comment,String> {

    List<Comment> findByOtelId(String otelId);

}
