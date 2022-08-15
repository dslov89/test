package com.umc.mwomeokji.domain.dish.dish.dto;

import com.umc.mwomeokji.domain.dish.dish.domain.Dish;
import com.umc.mwomeokji.domain.dish.dish.dto.DishDto.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DishMapper {

    Dish toEntity(DishPostRequest dishPostRequest, String imageUrl);

    DishNameResponse toDishNameResponse(Dish dish);

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
