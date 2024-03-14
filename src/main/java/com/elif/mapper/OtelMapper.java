package com.elif.mapper;

import com.elif.domain.Otel;
import com.elif.dto.request.OtelSaveRequestDto;
import com.elif.dto.response.OtelSaveResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface OtelMapper {
    OtelMapper INSTANCE = Mappers.getMapper(OtelMapper.class);

    Otel fromSaveRequestDtoToOtel(final OtelSaveRequestDto dto);
    OtelSaveResponseDto fromOtelToSaveResponseDto(final Otel otel);
}
