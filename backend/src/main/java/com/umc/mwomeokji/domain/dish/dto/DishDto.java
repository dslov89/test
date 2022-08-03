package com.umc.mwomeokji.domain.dish.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class DishDto {

    @Getter
    @RequiredArgsConstructor
    public static class DishNameResponse {
        private final Long id;
        private final String name;
    }

    @Getter
    @RequiredArgsConstructor
    public static class DishDetailsResponse {
        private final Long id;
        private final String name;
        private final String imageUrl;
        private final String videoUrl1;
        private final String videoUrl2;
        private final String videoUrl3;
    }
}
