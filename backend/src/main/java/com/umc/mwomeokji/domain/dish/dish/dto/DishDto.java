package com.umc.mwomeokji.domain.dish.dish.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

public class DishDto {

    @Getter
    @RequiredArgsConstructor
    public static class DishPostRequest {
        @NotBlank(message = "메뉴 이름은 null 이거나 빈 칸일 수 없습니다.")
        private final String name;
        @NotBlank(message = "메뉴 카테고리는 null 이거나 빈 칸일 수 없습니다.")
        private final String category;
        private final String videoUrl1;
        private final String videoUrl2;
        private final String videoUrl3;
    }

    @Getter
    @RequiredArgsConstructor
    public static class DishGetByNameRequest {
        @NotBlank(message = "메뉴 이름은 null 이거나 빈 칸일 수 없습니다.")
        private final String name;
    }

    @Getter
    @RequiredArgsConstructor
    public static class DishGetByCategoriesRequest {
        @NotBlank(message = "카테고리는 null 이거나 빈 칸일 수 없습니다.")
        private final String category;
    }

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
        private final String category;
        private final String imageUrl;
        private final String videoUrl1;
        private final String videoUrl2;
        private final String videoUrl3;
    }

    @Getter
    @RequiredArgsConstructor
    public static class DishesCountResponse {
        private final long count;
    }
}
