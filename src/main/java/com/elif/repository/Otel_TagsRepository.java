package com.elif.repository;

import com.elif.domain.Otel;
import com.elif.domain.Otel_Tags;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Otel_TagsRepository extends MongoRepository<Otel_Tags,String> {
    List<Otel_Tags> findByOtelId(String id);

}
