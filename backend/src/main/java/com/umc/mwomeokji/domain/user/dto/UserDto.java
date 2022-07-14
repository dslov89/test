package com.umc.mwomeokji.domain.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class UserDto {

    @Getter
    @RequiredArgsConstructor
    public static class SignUpRequest {
        private final String name;
        private final String email;
    }

    @Getter
    @RequiredArgsConstructor
    public static class SignUpResponse {
        private final String name;
        private final String email;
    }
}
