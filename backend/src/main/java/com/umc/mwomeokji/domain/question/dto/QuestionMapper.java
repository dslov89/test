package com.umc.mwomeokji.domain.question.dto;

import com.umc.mwomeokji.domain.questiondish.domain.QuestionDish;
import com.umc.mwomeokji.domain.dish.dish.domain.Dish;
import com.umc.mwomeokji.domain.dish.dish.dto.DishDto;
import com.umc.mwomeokji.domain.question.domain.Question;
import org.mapstruct.Mapper;
import com.umc.mwomeokji.domain.question.dto.QuestionDto.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question toEntity(QuestionPostRequest questionPostRequest);

    default QuestionsNameResponse toQuestionsNameResponse(List<Question> questions) {
        return new QuestionsNameResponse(questions.stream().map(question -> question.getQuestion()).collect(Collectors.toList()));
    }

    default QuestionAndDishesResponse toQuestionAndDishesResponse(Question question, List<QuestionDish> questionDishes) {
        List<Dish> dishes = questionDishes
                .stream().map(questionDish -> questionDish.getDish()).collect(Collectors.toList());
        List<DishDto.DishNameResponse> dishesNameResponses = dishes
                .stream().map(dish -> new DishDto.DishNameResponse(dish.getId(), dish.getName())).collect(Collectors.toList());
        return new QuestionAndDishesResponse(question.getQuestion(), dishesNameResponses);
    }
}
