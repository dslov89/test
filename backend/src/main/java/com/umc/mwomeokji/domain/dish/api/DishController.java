package com.umc.mwomeokji.domain.dish.api;

import com.umc.mwomeokji.domain.dish.application.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RequestMapping("/dishes")
@RestController
public class DishController {

    private final DishService dishService;

    @GetMapping("/name")
    public ResponseEntity<List<String>> getAllDishesName() {
        List<String> dishesName = new ArrayList<>(Stream.of("테스트 리스트입니다", "라면", "떡볶이", "기타 등등").collect(Collectors.toList()));
        return ResponseEntity.status(OK).body(dishesName);
    }

    @GetMapping("/image-url/{id}")
    public ResponseEntity<String> getDishesImageUrl(@PathVariable Long id) {
        return ResponseEntity.status(OK).body("테스트 url 입니다.");
    }
}
