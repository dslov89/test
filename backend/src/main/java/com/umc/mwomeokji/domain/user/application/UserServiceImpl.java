package com.umc.mwomeokji.domain.user.application;

import com.umc.mwomeokji.domain.user.dao.UserRepository;
import com.umc.mwomeokji.domain.user.dto.UserDto.SignUpRequest;
import com.umc.mwomeokji.domain.user.dto.UserDto.SignUpResponse;
import com.umc.mwomeokji.domain.user.dto.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        return userMapper.toSignUpResponse(userRepository.save(userMapper.toEntity(signUpRequest)));
    }
}
