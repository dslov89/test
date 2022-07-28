package com.umc.mwomeokji.domain.question.api;

import com.umc.mwomeokji.domain.question.application.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RequestMapping("/questions")
@RestController
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<String>> getAllQuestions(){
        List<String> questionList = new ArrayList<>(Stream.of("question1","question2").collect(Collectors.toList()));
        return ResponseEntity.status(OK).body(questionList);
    }

    @GetMapping("/dishes")
    public ResponseEntity<Map<String, List<String>>> getAllQuestionAndDishes(){
        Map<String, List<String>> questionAndDishes = Map.of(
                "question1", new ArrayList<>(Stream.of("").collect(Collectors.toList())),
                "question2", new ArrayList<>(Stream.of("").collect(Collectors.toList()))
        );
        return ResponseEntity.status(OK).body(questionAndDishes);
    }
}
