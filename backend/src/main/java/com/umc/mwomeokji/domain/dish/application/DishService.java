package com.umc.mwomeokji.domain.dish.application;

import com.umc.mwomeokji.domain.dish.dto.DishDto.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DishService {

    DishDetailsResponse saveDish(DishPostRequest request, MultipartFile multipartFile);

    List<DishNameResponse> getAllDishesName();

    DishDetailsResponse getDishDetails(Long id);

    DishDetailsResponse getDishDetails(DishGetByNameRequest request);

    DishesCountResponse getDishesCount();

    DishDetailsResponse getDishRandom();

}
