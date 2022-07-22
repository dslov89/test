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
    public ResponseEntity<List<String>> getAllQuestions() {
        List<String> questionsList = new ArrayList<>(Stream.of("가벼운 식사를 원하시나요?", "시원한 음식은 어떠신가요?").collect(Collectors.toList()));
        return ResponseEntity.status(OK).body(questionsList);
    }

    @GetMapping("/dishes")
    public ResponseEntity<Map<String, List<String>>> getAllQuestionsAndDishes() {
        Map<String, List<String>> questionsAndDishes = Map.of(
                "가벼운 식사를 원하시나요?", new ArrayList<>(Stream.of("샐러드", "샌드위치").collect(Collectors.toList())),
                "시원한 음식은 어떠신가요?", new ArrayList<>(Stream.of("냉면", "냉모밀").collect(Collectors.toList()))
        );
        return ResponseEntity.status(OK).body(questionsAndDishes);
    }
}
