package com.elif.service;

import com.elif.domain.Auth;
import com.elif.dto.request.ActivateStatusRequestDto;
import com.elif.dto.request.LoginRequestDto;
import com.elif.dto.request.RegisterRequestDto;
import com.elif.dto.response.ResgisterResponseDto;
import com.elif.exception.ErrorType;
import com.elif.exception.OtelException;
import com.elif.mapper.AuthMapper;
import com.elif.repository.AuthRepository;
import com.elif.utility.CodeGenerator;
import com.elif.utility.Enum.EStatus;
import com.elif.utility.JwtTokenManager;
import com.elif.utility.ServiceManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,String> {
    private final AuthRepository authRepository;
    private final JwtTokenManager jwtTokenManager;
    public AuthService(JwtTokenManager jwtTokenManager,AuthRepository authRepository) {
        super(authRepository);
        this.authRepository = authRepository;
        this.jwtTokenManager=jwtTokenManager;
    }

    public ResgisterResponseDto register(RegisterRequestDto dto) {
       Optional<Auth>optionalByUsername= authRepository.findByUsername(dto.getUsername());
       Optional<Auth>optionalByEmail= authRepository.findByEmail(dto.getEmail());
       if(optionalByEmail.isPresent() || optionalByUsername.isPresent()){
           throw new OtelException(ErrorType.USER_ALLREADY_EXIST);
       }
        Auth auth= AuthMapper.INSTANCE.fromAuthRegisterRequestDtoToAuth(dto);
        auth.setActivationCode(CodeGenerator.generateCode());
        save(auth);
       return AuthMapper.INSTANCE.fromAuthToRegisterResponseDto(auth);
    }

    public String login(LoginRequestDto dto) {
        Optional<Auth> authOptional = authRepository.findOptionalByUsernameAndPassword(dto.getUsername(),dto.getPassword());
        if(authOptional.isEmpty()){
            throw new OtelException(ErrorType.LOGIN_ERROR);
        }
        if(authOptional.get().getStatus().equals(EStatus.ACTIVE)){
            return jwtTokenManager.createToken(authOptional.get().getId(),authOptional.get().getRole())
                    .orElseThrow(() -> {throw new OtelException(ErrorType.TOKEN_NOT_CREATED);});
        } else {
            throw new OtelException(ErrorType.ACCOUNT_NOT_ACTIVE);
        }
    }

    public Boolean activateStatus(ActivateStatusRequestDto dto) {
        Optional<Auth> optionalAuth = findById(dto.getAuthId());
        if(optionalAuth.isEmpty()){
            throw new OtelException(ErrorType.USER_NOT_FOUND);
        }
        if(optionalAuth.get().getActivationCode().equals(dto.getActivationCode())){
            optionalAuth.get().setStatus(EStatus.ACTIVE);
            update(optionalAuth.get());
            return true;
        } else {
            throw new OtelException(ErrorType.ACTIVATION_CODE_ERROR);
        }
    }
}
