package com.umc.mwomeokji.domain.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {

    @Getter
    @RequiredArgsConstructor
    public static class SignUpRequest {
        @NotBlank(message = "이름은 null 이거나 빈 칸일 수 없습니다.")
        @Size(min = 1, max = 10, message = "이름은 1자 이상 10자 이하로 입력해주세요.")
        private final String name;
        @NotBlank(message = "이메일은 null 이거나 빈 칸일 수 없습니다.")
        @Email(message = "이메일 형식이 일치하지 않습니다.")
        private final String email;
    }

    @Getter
    @RequiredArgsConstructor
    public static class SignUpResponse {
        private final String name;
        private final String email;
    }
}
