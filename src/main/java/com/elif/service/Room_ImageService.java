package com.elif.service;

import com.elif.domain.Room_Image;
import com.elif.repository.Room_ImageRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;


@Service
public class Room_ImageService extends ServiceManager<Room_Image,String> {
    private final Room_ImageRepository repository;
    public Room_ImageService(Room_ImageRepository repository ) {
        super(repository);
        this.repository = repository;

    }

}
