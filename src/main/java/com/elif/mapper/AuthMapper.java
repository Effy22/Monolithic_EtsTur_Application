package com.elif.mapper;

import com.elif.domain.Auth;
import com.elif.dto.request.RegisterRequestDto;
import com.elif.dto.response.ResgisterResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthMapper {

    AuthMapper INSTANCE= Mappers.getMapper(AuthMapper.class);

    Auth fromAuthRegisterRequestDtoToAuth(final RegisterRequestDto dto);

    ResgisterResponseDto fromAuthToRegisterResponseDto(Auth auth);

}
