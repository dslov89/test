package com.umc.mwomeokji.domain.dish.dish.dto;

import com.umc.mwomeokji.domain.dish.category.domain.Category;
import com.umc.mwomeokji.domain.dish.dish.domain.Dish;
import com.umc.mwomeokji.domain.dish.dish.dto.DishDto.*;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface DishMapper {

    default Dish toEntity(DishPostRequest dishPostRequest, String imageUrl, Category category) {
        return Dish.builder()
                .name(dishPostRequest.getName())
                .category(category)
                .imageUrl(imageUrl)
                .videoUrl1(dishPostRequest.getVideoUrl1())
                .videoUrl2(dishPostRequest.getVideoUrl2())
                .videoUrl3(dishPostRequest.getVideoUrl3())
                .build();
    }

    DishNameResponse toDishNameResponse(Dish dish);

    default List<DishNameResponse> toDishNameResponses(List<Dish> dishes) {
        return dishes.stream().map(entity -> toDishNameResponse(entity)).collect(Collectors.toList());
    }

    default DishDetailsResponse toDishDetailsResponse(Dish dish) {
        return new DishDetailsResponse(
                dish.getId(),
                dish.getName(),
                dish.getCategory().getCategory(),
                dish.getImageUrl(),
                dish.getVideoUrl1(),
                dish.getVideoUrl2(),
                dish.getVideoUrl3()
        );
    }

    DishesCountResponse toDishesCountResponse(Long count);
}
