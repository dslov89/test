package com.umc.mwomeokji.domain.dish.dto;

import com.umc.mwomeokji.domain.dish.domain.Dish;
import org.mapstruct.Mapper;
import com.umc.mwomeokji.domain.dish.dto.DishDto.*;

@Mapper
public interface DishMapper {

    DishesNameResponse toDishesNameResponse(Dish dish);

    DishDetailsResponse toDishDetailsResponse(Dish dish);
}
