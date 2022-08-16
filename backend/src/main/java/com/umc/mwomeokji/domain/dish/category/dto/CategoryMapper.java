package com.umc.mwomeokji.domain.dish.category.dto;

import com.umc.mwomeokji.domain.dish.category.domain.Category;
import com.umc.mwomeokji.domain.dish.category.dto.CategoryDto.*;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    default CategoriesNameResponse toCategoriesNameResponse(List<Category> categoriesList) {
        return new CategoriesNameResponse(categoriesList.stream().map(category -> category.getCategory()).collect(Collectors.toList()));
    }
}
