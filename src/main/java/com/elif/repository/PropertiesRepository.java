package com.elif.repository;

import com.elif.domain.Properties;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertiesRepository extends MongoRepository<Properties,String> {

    Optional<Properties> findByName(String name);

    List<Properties> findByParentId(String parentId);

}
