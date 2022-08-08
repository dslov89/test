package com.umc.mwomeokji.domain.questiondish.api;

import com.umc.mwomeokji.domain.questiondish.application.QuestionDishService;
import com.umc.mwomeokji.domain.questiondish.dto.QuestionDishDto.*;
import com.umc.mwomeokji.domain.question.application.QuestionService;
import com.umc.mwomeokji.domain.question.dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RequestMapping("/question-dishes")
@RestController
public class QuestionDishController {

    private final QuestionDishService questionDishService;
    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody QuestionDishesPostRequest request) {
        questionDishService.saveQuestionDishes(request);
        return ResponseEntity.status(CREATED).body("성공적으로 저장되었습니다.");
    }

    @GetMapping
    public ResponseEntity<List<QuestionDto.QuestionAndDishesResponse>> getQuestionDishes() {
        return ResponseEntity.status(OK).body(questionService.getQuestionAndDishes());
    }
}
