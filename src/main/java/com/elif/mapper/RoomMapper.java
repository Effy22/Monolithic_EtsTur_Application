package com.elif.mapper;

import com.elif.domain.Room;
import com.elif.dto.request.RoomSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoomMapper {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    Room fromSaveRequestDtoToRoom(final RoomSaveRequestDto dto);

}
