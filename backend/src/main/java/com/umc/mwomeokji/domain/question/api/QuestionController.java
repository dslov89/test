package com.umc.mwomeokji.domain.question.api;

import com.umc.mwomeokji.domain.question.application.QuestionService;
import com.umc.mwomeokji.domain.question.dto.QuestionDto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Tag(name = "question", description = "질문 관련 API")
@RequiredArgsConstructor
@RequestMapping("/questions")
@RestController
public class QuestionController {

    private final QuestionService questionService;

    @Operation(summary = "질문 저장 API", description = "새로운 질문을 저장하기 위한 API 입니다.")
    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody QuestionPostRequest request) {
        questionService.saveQuestion(request);
        return ResponseEntity.status(CREATED).body("성공적으로 저장되었습니다.");
    }

    @Operation(summary = "CSV 파일을 이용한 질문 저장 API", description = "CSV 파일을 이용하여 질문을 저장하기 위한 API 입니다.")
    @PostMapping("upload/csv")
    public ResponseEntity<String> saveQuestionByCsv(@RequestPart(name = "file") MultipartFile file) {
        questionService.saveQuestionByCsv(file);
        return ResponseEntity.status(CREATED).body("성공적으로 저장되었습니다.");
    }

    @Operation(summary = "모든 질문 조회 API", description = "저장된 모든 질문을 조회하기 위한 API 입니다.")
    @GetMapping
    public ResponseEntity<QuestionsNameResponse> getAllQuestions(){
        return ResponseEntity.status(OK).body(questionService.getAllQuestionsName());
    }

    @Operation(summary = "질문 - 메뉴 쌍 조회 API", description = "저장된 모든 질문 - 메뉴 쌍을 조회하기 위한 API 입니다.")
    @GetMapping("/dishes")
    public ResponseEntity<List<QuestionAndDishesResponse>> getQuestionDishes() {
        return ResponseEntity.status(OK).body(questionService.getQuestionAndDishes());
    }
}