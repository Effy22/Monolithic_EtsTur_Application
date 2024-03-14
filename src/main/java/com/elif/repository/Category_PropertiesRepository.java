package com.elif.repository;

import com.elif.domain.Category_Properties;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Category_PropertiesRepository extends MongoRepository<Category_Properties,String> {

    Optional<Category_Properties> findOptionalByCategoryIdAndPropertyId(String categoryId, String propertyId);

}
