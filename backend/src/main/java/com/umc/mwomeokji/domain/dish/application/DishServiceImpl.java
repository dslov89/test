package com.umc.mwomeokji.domain.dish.application;

import com.umc.mwomeokji.domain.dish.dao.DishRepository;
import com.umc.mwomeokji.domain.dish.domain.Dish;
import com.umc.mwomeokji.domain.dish.dto.DishDto.*;
import com.umc.mwomeokji.domain.dish.dto.DishMapper;
import com.umc.mwomeokji.domain.dish.exception.NotFoundDishException;
import com.umc.mwomeokji.infra.s3.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class DishServiceImpl implements DishService{

    private final DishRepository dishRepository;
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
    public DishDetailsResponse getDishRandom() {
        long qty = dishRepository.count();
        long idx = (long)(Math.random() * qty)+ 1;
        return dishMapper.toDishDetailsResponse(dishRepository.findById(idx).orElseThrow(NotFoundDishException::new));
    }
}
