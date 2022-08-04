package com.umc.mwomeokji.domain.question.dto;

import com.umc.mwomeokji.domain.QuestionDish.domain.QuestionDish;
import com.umc.mwomeokji.domain.dish.domain.Dish;
import com.umc.mwomeokji.domain.dish.dto.DishDto;
import com.umc.mwomeokji.domain.question.domain.Question;
import org.mapstruct.Mapper;
import com.umc.mwomeokji.domain.question.dto.QuestionDto.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionsNameResponse toQuestionNameResponse(Question question);

    default QuestionAndDishesResponse toQuestionAndDishesResponse(Question question, List<QuestionDish> questionDishList) {
        List<Dish> dishesList = questionDishList
                .stream().map(questionDish -> questionDish.getDish()).collect(Collectors.toList());
        List<DishDto.DishNameResponse> dishesNameResponseList = dishesList
                .stream().map(dish -> new DishDto.DishNameResponse(dish.getId(), dish.getName())).collect(Collectors.toList());
        return new QuestionAndDishesResponse(question.getQuestion(), dishesNameResponseList);
    }
}
