package com.umc.mwomeokji.domain.dish.dao;

import com.umc.mwomeokji.domain.dish.domain.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {

}
