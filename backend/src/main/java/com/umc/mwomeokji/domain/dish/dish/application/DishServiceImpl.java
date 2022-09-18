package com.umc.mwomeokji.domain.dish.dish.application;

import com.umc.mwomeokji.domain.dish.category.dao.CategoryRepository;
import com.umc.mwomeokji.domain.dish.category.domain.Category;
import com.umc.mwomeokji.domain.dish.category.exception.NotFoundCategoryException;
import com.umc.mwomeokji.domain.dish.dish.dao.DishRepository;
import com.umc.mwomeokji.domain.dish.dish.domain.Dish;
import com.umc.mwomeokji.domain.dish.dish.dto.DishDto.*;
import com.umc.mwomeokji.domain.dish.dish.dto.DishMapper;
import com.umc.mwomeokji.domain.dish.dish.exception.NotEqualSizeException;
import com.umc.mwomeokji.domain.dish.dish.exception.NotFoundDishException;
import com.umc.mwomeokji.global.util.csv.DishCsvReader;
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
        Dish dish = dishRepository.save(dishMapper.toEntity(request, imageUrl, findByCategory(request.getCategory())));
        return dishMapper.toDishDetailsResponse(dish);
    }

    @Override
    public List<DishNameResponse> saveDishByCsv(MultipartFile file, List<MultipartFile> images) {
        DishCsvReader dishCsvReader = new DishCsvReader(file);
        List<DishPostRequest> dishPostRequestList = dishCsvReader.getDishPostRequests(dishCsvReader.readAll());
        if (dishPostRequestList.size() != images.size()) {
            throw new NotEqualSizeException();
        }
        List<String> imageUrls = images.stream().map(image -> fileService.uploadImage(image)).collect(Collectors.toList());
        List<Dish> dishesList = new ArrayList<>();
        for (int i = 0; i < dishPostRequestList.size(); i++){
            dishesList.add(dishMapper.toEntity(dishPostRequestList.get(i), imageUrls.get(i), findByCategory(dishPostRequestList.get(i).getCategory())));
        }
        dishRepository.saveAll(dishesList);
        return dishMapper.toDishNameResponseList(dishesList);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DishNameResponse> getAllDishesName() {
        List<Dish> dishesList = dishRepository.findAll();
        return dishMapper.toDishNameResponseList(dishesList);
    }

    @Override
    @Transactional(readOnly = true)
    public DishDetailsResponse getDishDetails(Long id) {
        return dishMapper.toDishDetailsResponse(dishRepository.findById(id).orElseThrow(NotFoundDishException::new));
    }

    @Override
    @Transactional(readOnly = true)
    public DishDetailsResponse getDishDetails(DishGetByNameRequest request) {
        Dish dish = dishRepository.findByName(removeBlank(request.getName())).orElseThrow(NotFoundDishException::new);
        return dishMapper.toDishDetailsResponse(dish);
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

    private Category findByCategory(String categoryName) {
        return categoryRepository.findByCategory(categoryName).orElseThrow(NotFoundCategoryException::new);
    }

    private String removeBlank(String str) {
        return str.replaceAll(" ", "");
    }

    private Dish selectOneFromList(List<Dish> dishesList) {
        double randomIdx = Math.random() * dishesList.size();
        return dishesList.get((int)randomIdx);
    }

    private List<Dish> getDishByCategory(String categoryName) {
        Category category = findByCategory(categoryName);
        return dishRepository.findByCategory(category);
    }
}
