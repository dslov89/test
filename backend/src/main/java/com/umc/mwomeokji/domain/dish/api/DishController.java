package com.umc.mwomeokji.domain.dish.api;

import com.umc.mwomeokji.domain.dish.application.DishService;
import com.umc.mwomeokji.domain.dish.dto.DishDto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Tag(name = "dish", description = "메뉴 관련 API")
@RequiredArgsConstructor
@RequestMapping("/dishes")
@RestController
public class DishController {

    private final DishService dishService;

    @Operation(summary = "메뉴 저장 API", description = "새로운 메뉴를 저장하기 위한 API 입니다.")
    @PostMapping
    public ResponseEntity<DishDetailsResponse> save(
            @Valid @RequestPart(name = "request") DishPostRequest request,
            @RequestPart(required = false, name = "image") MultipartFile multipartFile) {
        return ResponseEntity.status(CREATED).body(dishService.saveDish(request, multipartFile));
    }

    @RequestBody()
    @Operation(summary = "메뉴 이름 조회 API", description = "저장된 모든 메뉴의 이름을 조회하기 위한 API 입니다.")
    @GetMapping("/name")
    public ResponseEntity<List<DishNameResponse>> getAllDishesName() {
        return ResponseEntity.status(OK).body(dishService.getAllDishesName());
    }

    @Operation(summary = "메뉴 상세 정보 조회 API", description = "요청한 메뉴의 상세 정보를 조회하기 위한 API 입니다.")
    @GetMapping("/{id}")
    public ResponseEntity<DishDetailsResponse> getDishDetails(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(dishService.getDishDetails(id));
    }

    @Operation(summary = "랜덤 메뉴 조회 API", description = "임의의 한 메뉴의 상세 정보를 조회하기 위한 API 입니다.")
    @GetMapping("/random")
    public ResponseEntity<DishDetailsResponse> getDishRandom() {
        return ResponseEntity.status(OK).body(dishService.getDishRandom());
    }
}
