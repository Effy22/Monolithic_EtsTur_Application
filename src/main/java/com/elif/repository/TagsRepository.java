package com.elif.repository;

import com.elif.domain.Tags;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagsRepository extends MongoRepository<Tags,String> {
    List<Tags> findByIdContaining(List<String> tagsList);

    Optional<Tags> findByName(String name);

}
