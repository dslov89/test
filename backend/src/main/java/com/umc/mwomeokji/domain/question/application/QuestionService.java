package com.umc.mwomeokji.domain.question.application;

import com.umc.mwomeokji.domain.question.dto.QuestionDto.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public interface QuestionService {

    void saveQuestion(QuestionPostRequest request);

    void saveQuestionByCsv(MultipartFile file);

    QuestionsNameResponse getAllQuestionsName();

    List<QuestionAndDishesResponse> getQuestionAndDishes();
}
