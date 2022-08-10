package com.umc.mwomeokji.domain.dish.api;

import com.umc.mwomeokji.domain.dish.application.DishService;
import com.umc.mwomeokji.domain.dish.dto.DishDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RequestMapping("/dishes")
@RestController
public class DishController {

    private final DishService dishService;

    @PostMapping
    public ResponseEntity<DishDetailsResponse> save(
            @Valid @RequestPart(name = "request") DishPostRequest request,
            @RequestPart(required = false, name = "image") MultipartFile multipartFile) {
        return ResponseEntity.status(CREATED).body(dishService.saveDish(request, multipartFile));
    }

    @GetMapping("/name")
    public ResponseEntity<List<DishNameResponse>> getAllDishesName() {
        return ResponseEntity.status(OK).body(dishService.getAllDishesName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishDetailsResponse> getDishDetails(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(dishService.getDishDetails(id));
    }

    @GetMapping("/random")
    public ResponseEntity<DishDetailsResponse> getDishRandom() {
        return ResponseEntity.status(OK).body(dishService.getDishRandom());
    }
}
