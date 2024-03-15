package com.elif.controller;

import com.elif.dto.request.ActivateStatusRequestDto;
import com.elif.dto.request.LoginRequestDto;
import com.elif.dto.request.RegisterRequestDto;
import com.elif.dto.response.RegisterResponseDto;
import com.elif.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.elif.constants.RestApiUrl.*;

@RequiredArgsConstructor
@RequestMapping(AUTH)
@RestController
public class AuthController {
    private final AuthService authService;

    @PostMapping(REGISTER)
    @CrossOrigin("*")
    public ResponseEntity<RegisterResponseDto> register (@RequestBody @Valid RegisterRequestDto dto){
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping(LOGIN)
    @CrossOrigin("*")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(authService.login(dto));
    }

    @GetMapping(ACTIVATE_STATUS + "/{activationCode}")
    @CrossOrigin("*")
    public ResponseEntity<String> activateStatus(@PathVariable String activationCode){
        return ResponseEntity.ok(authService.activateStatus(activationCode));

    }


}
