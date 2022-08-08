package com.umc.mwomeokji.domain.questiondish.application;

import com.umc.mwomeokji.domain.questiondish.dao.QuestionDishRepository;
import com.umc.mwomeokji.domain.questiondish.domain.QuestionDish;
import com.umc.mwomeokji.domain.questiondish.dto.QuestionDishDto.*;
import com.umc.mwomeokji.domain.dish.dao.DishRepository;
import com.umc.mwomeokji.domain.dish.domain.Dish;
import com.umc.mwomeokji.domain.dish.exception.NotFoundDishException;
import com.umc.mwomeokji.domain.question.dao.QuestionRepository;
import com.umc.mwomeokji.domain.question.domain.Question;
import com.umc.mwomeokji.domain.question.exception.NotFoundQuestionException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class QuestionDishServiceImpl implements QuestionDishService{

    private final QuestionDishRepository questionDishRepository;
    private final QuestionRepository questionRepository;
    private final DishRepository dishRepository;

    @Override
    public void saveQuestionDishes(QuestionDishesPostRequest request) {
        Question question = questionRepository.findById(request.getQuestionId()).orElseThrow(NotFoundQuestionException::new);
        List<Dish> dishesList = request.getDishIds().stream().map(
                id -> dishRepository.findById(id).orElseThrow(NotFoundDishException::new)
        ).collect(Collectors.toList());
        dishesList.forEach( dish -> questionDishRepository.save(QuestionDish.builder().question(question).dish(dish).build()));
    }
}
