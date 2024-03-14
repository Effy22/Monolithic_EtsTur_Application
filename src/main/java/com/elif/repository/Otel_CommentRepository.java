package com.elif.repository;

import com.elif.domain.Otel_Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Otel_CommentRepository extends MongoRepository<Otel_Comment,String> {


}
