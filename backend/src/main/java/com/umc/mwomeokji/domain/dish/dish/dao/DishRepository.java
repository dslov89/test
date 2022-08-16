package com.umc.mwomeokji.domain.dish.dish.dao;

import com.umc.mwomeokji.domain.dish.category.domain.Category;
import com.umc.mwomeokji.domain.dish.dish.domain.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {

    List<Dish> findByName(String name);

    List<Dish> findByCategory(Category category);
}
