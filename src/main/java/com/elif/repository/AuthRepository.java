package com.elif.repository;

import com.elif.domain.Auth;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends MongoRepository<Auth,String> {


    Optional<Auth> findByUsername(String username);

    Optional<Auth> findByEmail(String email);

    Optional<Auth> findOptionalByUsernameAndPassword(String username, String password);

}
