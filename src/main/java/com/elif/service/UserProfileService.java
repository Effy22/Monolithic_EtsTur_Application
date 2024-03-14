package com.elif.service;

import com.elif.domain.Otel;
import com.elif.domain.UserProfile;
import com.elif.dto.request.UserProfileUpdateRequestDto;
import com.elif.dto.response.UserProfileResponseDto;
import com.elif.exception.ErrorType;
import com.elif.exception.OtelException;
import com.elif.mapper.UserProfileMapper;
import com.elif.repository.UserProfileRepository;
import com.elif.utility.JwtTokenManager;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,String> {
    private final UserProfileRepository userProfileRepository;
    private final JwtTokenManager jwtTokenManager;
    private final OtelService otelService;

    public UserProfileService(OtelService otelService,UserProfileRepository userProfileRepository,JwtTokenManager jwtTokenManager) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
        this.jwtTokenManager = jwtTokenManager;
        this.otelService= otelService;
    }

    public Boolean addFavourite(String token, String otelId) {
        UserProfile userProfile=findByToken(token);
        userProfile.getFavOtels().add(otelId);
        userProfileRepository.save(userProfile);
        return true;
    }

    //Method that repeated;
    public UserProfile findByToken(String token) {
        Optional<String> authId = jwtTokenManager.getIdFromToken(token);
        if(authId.isEmpty()){
            throw new OtelException(ErrorType.INVALID_TOKEN);
        }
        return userProfileRepository.findByAuthId(authId.get()).get();
    }
    public UserProfileResponseDto findUserDtoByToken(String token) {
        UserProfile user = findByToken(token);
        return UserProfileResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .username(user.getUsername())
                .email(user.getEmail())
                .address(user.getAddress())
                .password(user.getPassword())
                .favOtels(user.getFavOtels())
                .build();
    }

    public UserProfileResponseDto updateUserProfile(UserProfileUpdateRequestDto dto){
        UserProfile user = findByToken(dto.getToken());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setAddress(dto.getAddress());
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setAddress(dto.getAddress());
        user.setPassword(dto.getPassword());
        userProfileRepository.save(user);
        return UserProfileMapper.INSTANCE.fromUserProfileToUserProfileResponseDto(user);
    }

    public List<Otel> getFavOtels(String token) {
        UserProfile user = findByToken(token);
        return otelService.findAllByOtelIdIn(user.getFavOtels());
    }
}
