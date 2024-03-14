package com.elif.repository;

import com.elif.domain.Room_Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Room_ImageRepository extends MongoRepository<Room_Image,String> {


}
