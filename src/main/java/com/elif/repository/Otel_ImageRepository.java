package com.elif.repository;

import com.elif.domain.Otel_Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Otel_ImageRepository extends MongoRepository<Otel_Image,String> {

}
