package com.umc.mwomeokji.domain.dish.application;

import com.umc.mwomeokji.domain.dish.dao.DishRepository;
import com.umc.mwomeokji.domain.dish.domain.Dish;
import com.umc.mwomeokji.domain.dish.dto.DishDto.DishDetailsResponse;
import com.umc.mwomeokji.domain.dish.dto.DishDto.DishNameResponse;
import com.umc.mwomeokji.domain.dish.dto.DishMapper;
import com.umc.mwomeokji.domain.dish.exception.NotFoundDishException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class DishServiceImpl implements DishService{

    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    @Override
    @Transactional(readOnly = true)
    public List<DishNameResponse> getAllDishesName() {
        List<Dish> dishesList = dishRepository.findAll();
        return dishesList.stream().map(dish -> dishMapper.toDishNameResponse(dish)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DishDetailsResponse getDishDetails(Long id) {
        return dishMapper.toDishDetailsResponse(
                dishRepository.findById(id)
                        .orElseThrow(NotFoundDishException::new)
        );
    }
}
