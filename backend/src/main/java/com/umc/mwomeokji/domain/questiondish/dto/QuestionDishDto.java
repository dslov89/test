package com.umc.mwomeokji.domain.questiondish.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class QuestionDishDto {

    @Getter
    @RequiredArgsConstructor
    public static class QuestionDishesPostRequest {
        @NotNull(message = "질문 id 는 null 일 수 없습니다.")
        private final Long questionId;
        @NotNull(message = "질문에 해당하는 메뉴는 null 일 수 없습니다.")
        @Size(min = 1, message = "질문에 해당하는 메뉴는 최소 1개 이상이어야 합니다.")
        private final List<String> dishes;
    }
}
