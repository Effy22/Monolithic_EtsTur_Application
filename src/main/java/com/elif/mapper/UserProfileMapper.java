package com.elif.mapper;

import com.elif.domain.UserProfile;
import com.elif.dto.response.UserProfileResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserProfileMapper {
    UserProfileMapper INSTANCE = Mappers.getMapper(UserProfileMapper.class);

    UserProfileResponseDto fromUserProfileToUserProfileResponseDto(final UserProfile userProfile);
}
