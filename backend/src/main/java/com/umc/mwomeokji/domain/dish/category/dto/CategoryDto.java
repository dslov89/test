package com.umc.mwomeokji.domain.dish.category.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class CategoryDto {

    @Getter
    @RequiredArgsConstructor
    public static class CategoriesNameResponse {
        private final List<String> category;
    }
}
