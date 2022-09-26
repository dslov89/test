package com.umc.mwomeokji.domain.dish.dish.application;

import com.umc.mwomeokji.domain.dish.dish.dto.DishDto.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DishService {

    void saveDish(DishPostRequest request, MultipartFile multipartFile);

    void saveDishByCsv(MultipartFile file, List<MultipartFile> image);

    List<DishNameResponse> getAllDishesName();

    DishDetailsResponse getDishDetails(Long id);

    DishDetailsResponse getDishDetails(DishGetByNameRequest request);

    DishesCountResponse getDishesCount();

    DishDetailsResponse getDishRandom();

    DishDetailsResponse getDishCategoriesRandom(List<DishGetByCategoriesRequest> request);

}
