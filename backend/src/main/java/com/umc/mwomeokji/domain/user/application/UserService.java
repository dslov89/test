package com.umc.mwomeokji.domain.user.application;

import com.umc.mwomeokji.domain.user.dto.UserDto.*;

public interface UserService {

    SignUpResponse signUp(SignUpRequest signUpRequest);
}
