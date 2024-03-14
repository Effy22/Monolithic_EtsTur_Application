package com.elif.repository;

import com.elif.domain.Otel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface OtelRepository extends MongoRepository<Otel,String> {

    Optional<Otel> findByNameAndAddressId(String name, String addressId);

    List<Otel> findByNameContainingIgnoreCase(String search);

    List<Otel> findAllByAddressIdIn(List<String> addressListId);
    List<Otel> findAllByIdIn(List<String> otelIdList);

}
