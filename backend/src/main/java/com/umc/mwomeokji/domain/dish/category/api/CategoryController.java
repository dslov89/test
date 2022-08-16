package com.umc.mwomeokji.domain.dish.category.api;

import com.umc.mwomeokji.domain.dish.category.application.CategoryService;
import com.umc.mwomeokji.domain.dish.category.dto.CategoryDto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@Tag(name = "category", description = "카테고리 관련 API")
@RequiredArgsConstructor
@RequestMapping("/categories")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "모든 카테고리 조회 API", description = "저장된 모든 카테고리를 조회하기 위한 API 입니다.")
    @GetMapping
    public ResponseEntity<CategoriesNameResponse> getAllCategoriesName() {
        return ResponseEntity.status(OK).body(categoryService.getAllCategoriesName());
    }
}
