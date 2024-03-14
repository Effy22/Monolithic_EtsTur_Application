package com.elif.service;

import com.elif.domain.Room;
import com.elif.dto.request.RoomSaveRequestDto;
import com.elif.exception.ErrorType;
import com.elif.exception.OtelException;
import com.elif.mapper.RoomMapper;
import com.elif.repository.RoomRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService extends ServiceManager<Room,String> {

    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Room save(RoomSaveRequestDto dto) {
        Optional<Room> optionalroom = repository.findByNameAndRoomNumber(dto.getName(),dto.getRoomNumber());
        if(optionalroom.isPresent()){
            throw new OtelException(ErrorType.ROOM_ALREADY_EXIST);
        }
        Room room = RoomMapper.INSTANCE.fromSaveRequestDtoToRoom(dto);
        return save(room);

    }
}
