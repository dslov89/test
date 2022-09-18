package com.umc.mwomeokji.domain.question.dto;

import com.umc.mwomeokji.domain.dish.dish.dto.DishDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class QuestionDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionPostRequest {
        @NotBlank(message = "질문 내용은 null 이거나 빈 칸일 수 없습니다.")
        private String question;
    }

    @Getter
    @RequiredArgsConstructor
    public static class QuestionsNameResponse {
        private final List<String> question;
    }

    @Getter
    @RequiredArgsConstructor
    public static class QuestionAndDishesResponse {
        private final String question;
        private final List<DishDto.DishNameResponse> dishes;
    }
}
