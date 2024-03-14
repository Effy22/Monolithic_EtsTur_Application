package com.elif.controller;

import com.elif.dto.request.ActivateStatusRequestDto;
import com.elif.dto.request.LoginRequestDto;
import com.elif.dto.request.RegisterRequestDto;
import com.elif.dto.response.ResgisterResponseDto;
import com.elif.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.elif.constants.RestApiUrl.*;

@RequiredArgsConstructor
@RequestMapping(AUTH)
@RestController
public class AuthController {
    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<ResgisterResponseDto> register (@RequestBody @Valid RegisterRequestDto dto){
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<String> login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(authService.login(dto));
    }

    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<Boolean> activateStatus(@RequestBody ActivateStatusRequestDto dto){
        return ResponseEntity.ok(authService.activateStatus(dto));
    }
}
