package com.umc.mwomeokji.domain.question.dto;

import com.umc.mwomeokji.domain.question.domain.Question;
import org.mapstruct.Mapper;
import com.umc.mwomeokji.domain.question.dto.QuestionDto.*;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionsNameResponse toQuestionNameResponse(Question question);

    QuestionAndDishesResponse toQuestionAndDishesResponse(Question question);
}
