package com.elif.repository;

import com.elif.domain.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile,String> {

   Optional<UserProfile> findByAuthId(String authId);

}
