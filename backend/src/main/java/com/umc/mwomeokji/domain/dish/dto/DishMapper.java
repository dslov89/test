package com.umc.mwomeokji.domain.dish.dto;

import com.umc.mwomeokji.domain.dish.domain.Dish;
import org.mapstruct.Mapper;
import com.umc.mwomeokji.domain.dish.dto.DishDto.*;

@Mapper(componentModel = "spring")
public interface DishMapper {

    Dish toEntity(DishPostRequest dishPostRequest, String imageUrl);

    DishNameResponse toDishNameResponse(Dish dish);

    DishDetailsResponse toDishDetailsResponse(Dish dish);

    DishesCountResponse toDishesCountResponse(Long count);
}
