package com.endpoints.fitnescenter.service;

import com.endpoints.fitnescenter.Model.request.LoginUserRequest;
import com.endpoints.fitnescenter.Model.response.LoginResponse;
import com.endpoints.fitnescenter.Model.response.WebResponseSuccess;
import com.endpoints.fitnescenter.entity.User;
import com.endpoints.fitnescenter.repository.UserRepository;
import com.endpoints.fitnescenter.security.BCrypt;
import com.endpoints.fitnescenter.util.EmailUtil;
import com.endpoints.fitnescenter.util.OtpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@Slf4j
public class AuthService {

    @Autowired
    private OtpUtil otpUtil;

    @Autowired
    private  EmailUtil emailUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public LoginResponse login(LoginUserRequest request){
        validationService.validate(request);

        User user = userRepository.findFirstByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email atau Password salah ciiinnnn ... !!!"));

        if (!BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email atau Password salah ciiinnnn ... !!!");
        }else if (!user.isActive()){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Your account is not verified");
        }else {
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(tokenExpired());
            userRepository.save(user);

            return LoginResponse.builder()
                    .name(user.getName())
                    .token(user.getToken())
                    .tokenExpiredAt(user.getTokenExpiredAt())
                    .build();
        }
    }

    @Transactional
    public void logout(User user){
        user.setToken(null);
        user.setTokenExpiredAt(null);
        userRepository.save(user);
    }

    private Long tokenExpired() {
        return System.currentTimeMillis() + (6000000);
    }

}
