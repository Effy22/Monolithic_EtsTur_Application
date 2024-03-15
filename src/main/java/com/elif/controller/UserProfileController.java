package com.elif.controller;

import com.elif.domain.Otel;
import com.elif.domain.UserProfile;
import com.elif.dto.request.UserProfileUpdateRequestDto;
import com.elif.dto.response.UserProfileResponseDto;
import com.elif.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.elif.constants.RestApiUrl.*;

@RequiredArgsConstructor
@RequestMapping(USER)
@RestController
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(ADD_FAVOURITE)
    @CrossOrigin("*")
    public ResponseEntity<Boolean> addFavourite(@RequestParam String token, @RequestParam String otelId) {
        return ResponseEntity.ok(userProfileService.addFavourite(token, otelId));
    }

    @PostMapping(FIND_BY_TOKEN)
    @CrossOrigin("*")
    public ResponseEntity<UserProfileResponseDto> findByToken(@RequestParam String token) {
        return ResponseEntity.ok(userProfileService.findUserDtoByToken(token));
    }

    @PostMapping(UPDATE)
    @CrossOrigin("*")
    public ResponseEntity<UserProfileResponseDto> updateUserProfile(@RequestBody UserProfileUpdateRequestDto dto) {
        return ResponseEntity.ok(userProfileService.updateUserProfile(dto));
    }

    @PostMapping(GET_FAV_OTELS)
    @CrossOrigin("*")
    public ResponseEntity<List<Otel>> getFavOtels(@RequestParam String token) {
        return ResponseEntity.ok(userProfileService.getFavOtels(token));
    }


}
