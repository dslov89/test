package com.umc.mwomeokji.domain.dish.dish.application;

import com.umc.mwomeokji.domain.dish.category.dao.CategoryRepository;
import com.umc.mwomeokji.domain.dish.category.domain.Category;
import com.umc.mwomeokji.domain.dish.category.exception.NotFoundCategoryException;
import com.umc.mwomeokji.domain.dish.dish.dao.DishRepository;
import com.umc.mwomeokji.domain.dish.dish.domain.Dish;
import com.umc.mwomeokji.domain.dish.dish.dto.DishDto.*;
import com.umc.mwomeokji.domain.dish.dish.dto.DishMapper;
import com.umc.mwomeokji.domain.dish.dish.exception.NotFoundDishException;
import com.umc.mwomeokji.infra.s3.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class DishServiceImpl implements DishService{

    private final DishRepository dishRepository;
    private final CategoryRepository categoryRepository;
    private final DishMapper dishMapper;
    private final FileService fileService;

    @Override
    public DishDetailsResponse saveDish(DishPostRequest request, MultipartFile multipartFile) {
        String imageUrl = fileService.uploadImage(multipartFile);
        Dish dish = dishRepository.save(dishMapper.toEntity(request, imageUrl));
        return dishMapper.toDishDetailsResponse(dish);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DishNameResponse> getAllDishesName() {
        List<Dish> dishesList = dishRepository.findAll();
        return dishesList.stream().map(dish -> dishMapper.toDishNameResponse(dish)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DishDetailsResponse getDishDetails(Long id) {
        return dishMapper.toDishDetailsResponse(dishRepository.findById(id).orElseThrow(NotFoundDishException::new));
    }

    @Override
    @Transactional(readOnly = true)
    public DishDetailsResponse getDishDetails(DishGetByNameRequest request) {
        List<Dish> dishesList = dishRepository.findByName(removeBlank(request.getName()));
        if (dishesList.isEmpty()) {
            throw new NotFoundDishException();
        }
        return dishMapper.toDishDetailsResponse(selectOneFromList(dishesList));
    }

    @Override
    @Transactional(readOnly = true)
    public DishesCountResponse getDishesCount() {
        Long count = dishRepository.count();
        return dishMapper.toDishesCountResponse(count);
    }

    @Override
    @Transactional(readOnly = true)
    public DishDetailsResponse getDishRandom() {
        long qty = dishRepository.count();
        long idx = (long)(Math.random() * qty)+ 1;
        return dishMapper.toDishDetailsResponse(dishRepository.findById(idx).orElseThrow(NotFoundDishException::new));
    }

    @Override
    @Transactional(readOnly = true)
    public DishDetailsResponse getDishCategoriesRandom(List<DishGetByCategoriesRequest> request) {
        List<Dish> dishesList = new ArrayList<>();
        request.forEach(category -> dishesList.addAll(getDishByCategory(category.getCategory())));
        if (dishesList.isEmpty()) {
            throw new NotFoundDishException();
        }
        return dishMapper.toDishDetailsResponse(selectOneFromList(dishesList));
    }

    private String removeBlank(String str) {
        return str.replaceAll(" ", "");
    }

    private Dish selectOneFromList(List<Dish> dishesList) {
        double randomIdx = Math.random() * dishesList.size();
        return dishesList.get((int)randomIdx);
    }

    private List<Dish> getDishByCategory(String categoryName) {
        Category category = categoryRepository.findByCategory(categoryName).orElseThrow(NotFoundCategoryException::new);
        return dishRepository.findByCategory(category);
    }
}
