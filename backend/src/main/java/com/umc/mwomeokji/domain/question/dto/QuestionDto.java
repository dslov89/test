package com.umc.mwomeokji.domain.question.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class QuestionDto {

    @Getter
    @RequiredArgsConstructor
    public static class QuestionsNameResponse {
        private final String question;
    }

    @Getter
    @RequiredArgsConstructor
    public static class QuestionAndDishesResponse {
        private final String category;
    }
}
