package com.elif.repository;

import com.elif.domain.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends MongoRepository<Address,String> {
    Optional<Address> findByStreetNumberAndDistrict(String streetNumber, String district);

    List<Address> findByNameContainingIgnoreCase(String search);

    List<Address> findByNameContainingIgnoreCaseOrStreetNumberContainingIgnoreCase(String name, String number);
}
