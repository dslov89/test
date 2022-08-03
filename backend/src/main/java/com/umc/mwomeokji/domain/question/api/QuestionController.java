package com.umc.mwomeokji.domain.question.api;

import com.umc.mwomeokji.domain.question.application.QuestionService;
import com.umc.mwomeokji.domain.question.dto.QuestionDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RequestMapping("/questions")
@RestController
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<QuestionsNameResponse>> getAllQuestions(){
        return ResponseEntity.status(OK).body(questionService.getAllQuestionsName());
    }

    @GetMapping("/dishes")
    public ResponseEntity<List<QuestionAndDishesResponse>> getQuestionAndDishes() {
        return ResponseEntity.status(OK).body(questionService.getQuestionAndDishes());
    }
}
