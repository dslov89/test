package com.umc.mwomeokji.domain.dish.category.application;

import com.umc.mwomeokji.domain.dish.category.dao.CategoryRepository;
import com.umc.mwomeokji.domain.dish.category.dto.CategoryDto.*;
import com.umc.mwomeokji.domain.dish.category.dto.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    @Transactional(readOnly = true)
    public CategoriesNameResponse getAllCategoriesName() {
        return categoryMapper.toCategoriesNameResponse(categoryRepository.findAll());
    }
}
