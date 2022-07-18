package com.umc.mwomeokji.domain.user.application;

import com.umc.mwomeokji.domain.user.dao.UserRepository;
import com.umc.mwomeokji.domain.user.dto.UserDto.*;
import com.umc.mwomeokji.domain.user.dto.UserMapper;
import com.umc.mwomeokji.domain.user.exception.DuplicateEmailException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.umc.mwomeokji.global.error.exception.ExceptionCodeAndDetails.DUPLICATED_USER_EMAIL;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())){
            throw new DuplicateEmailException(DUPLICATED_USER_EMAIL);
        }
        return userMapper.toSignUpResponse(userRepository.save(userMapper.toEntity(signUpRequest)));
    }
}
