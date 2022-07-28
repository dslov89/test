package com.umc.mwomeokji.domain.question.application;

import com.umc.mwomeokji.domain.question.dto.QuestionDto.*;

import java.util.List;
public interface QuestionService {

    List<QuestionsNameResponse> getAllQuestionsName();
}
