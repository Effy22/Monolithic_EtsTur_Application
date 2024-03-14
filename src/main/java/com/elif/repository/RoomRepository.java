package com.elif.repository;

import com.elif.domain.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends MongoRepository<Room,String> {
    Optional<Room> findByNameAndRoomNumber(String name, int roomNumber);

}
