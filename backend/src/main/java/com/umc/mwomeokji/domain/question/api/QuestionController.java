package com.umc.mwomeokji.domain.question.api;

import com.umc.mwomeokji.domain.question.application.QuestionService;
import com.umc.mwomeokji.domain.question.dto.QuestionDto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Tag(name = "question", description = "질문 관련 API")
@RequiredArgsConstructor
@RequestMapping("/questions")
@RestController
public class QuestionController {

    private final QuestionService questionService;

    @Operation(summary = "모든 질문 조회 API", description = "저장된 모든 질문을 조회하기 위한 API 입니다.")
    @GetMapping
    public ResponseEntity<List<QuestionsNameResponse>> getAllQuestions(){
        return ResponseEntity.status(OK).body(questionService.getAllQuestionsName());
    }
}
