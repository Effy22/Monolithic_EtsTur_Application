package com.elif.repository;

import com.elif.domain.OtelProperties;
import com.elif.domain.Otel_Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Otel_PropertiesRepository extends MongoRepository<OtelProperties,String> {

}
