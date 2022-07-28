package com.umc.mwomeokji.domain.dish.api;

import com.umc.mwomeokji.domain.dish.application.DishService;
import com.umc.mwomeokji.domain.dish.dto.DishDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RequestMapping("/dishes")
@RestController
public class DishController {

    private final DishService dishService;

    @GetMapping("/name")
    public ResponseEntity<List<DishesNameResponse>> getAllDishesName() {
        return ResponseEntity.status(OK).body(dishService.getAllDishesName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishDetailsResponse> getDishDetails(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(dishService.getDishDetails(id));
    }
}
