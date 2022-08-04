package com.umc.mwomeokji.domain.QuestionDish.dao.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class QuestionDishDto {

    @Getter
    @RequiredArgsConstructor
    public static class QuestionDishesPostRequest {
        private final String question;
        private final List<String> dishesList;
    }
}
