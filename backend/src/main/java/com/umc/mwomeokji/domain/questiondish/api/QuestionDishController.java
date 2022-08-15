package com.umc.mwomeokji.domain.questiondish.api;

import com.umc.mwomeokji.domain.questiondish.application.QuestionDishService;
import com.umc.mwomeokji.domain.questiondish.dto.QuestionDishDto.*;
import com.umc.mwomeokji.domain.question.application.QuestionService;
import com.umc.mwomeokji.domain.question.dto.QuestionDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Tag(name = "question-dish", description = "질문 - 메뉴 쌍 관련 API")
@RequiredArgsConstructor
@RequestMapping("/question-dishes")
@RestController
public class QuestionDishController {

    private final QuestionDishService questionDishService;
    private final QuestionService questionService;

    @Operation(summary = "질문-메뉴 쌍 저장 API", description = "새로운 질문 - 메뉴 쌍을 저장하기 위한 API 입니다.")
    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody QuestionDishesPostRequest request) {
        questionDishService.saveQuestionDishes(request);
        return ResponseEntity.status(CREATED).body("성공적으로 저장되었습니다.");
    }
}
