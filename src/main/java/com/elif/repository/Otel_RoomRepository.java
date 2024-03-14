package com.elif.repository;

import com.elif.domain.Otel_Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Otel_RoomRepository extends MongoRepository<Otel_Room, String> {


}
