package com.umc.mwomeokji.domain.user.dto;

import com.umc.mwomeokji.domain.user.dto.UserDto.*;
import com.umc.mwomeokji.domain.user.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignUpRequest signUpRequest);

    SignUpResponse toSignUpResponse(User user);
}
