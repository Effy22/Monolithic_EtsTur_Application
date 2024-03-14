package com.elif.repository;

import com.elif.domain.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends MongoRepository<Image,String> {
    Optional<Image> findByName(String name);

}
