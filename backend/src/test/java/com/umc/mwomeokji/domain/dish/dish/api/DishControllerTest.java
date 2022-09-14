package com.umc.mwomeokji.domain.dish.api;

import com.umc.mwomeokji.domain.dish.dish.api.DishController;
import com.umc.mwomeokji.domain.dish.dish.application.DishService;
import com.umc.mwomeokji.domain.dish.dish.dto.DishDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DishController.class)
class DishControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DishService dishService;

    @DisplayName("모든 메뉴 이름 조회")
    @Test
    void get_all_dishes_name() throws Exception {
        // given
        DishDto.DishNameResponse dishNameResponse1 = new DishDto.DishNameResponse(1L, "초밥");
        DishDto.DishNameResponse dishNameResponse2 = new DishDto.DishNameResponse(2L, "냉면");
        List<DishDto.DishNameResponse> dishesNameResponseList = Stream.of(dishNameResponse1, dishNameResponse2).collect(Collectors.toList());
        given(dishService.getAllDishesName()).willReturn(dishesNameResponseList);

        // when, then
        mockMvc.perform(get("/dishes/name"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(dishNameResponse1.getName()))
                .andExpect(jsonPath("$[1].name").value(dishNameResponse2.getName()))
                .andDo(print());
        verify(dishService, atMostOnce()).getAllDishesName();
    }

    @DisplayName("메뉴 상세 정보 조회")
    @Test
    void get_dish_details() throws Exception{
        // given
        DishDto.DishDetailsResponse dishDetailsResponse
                = new DishDto.DishDetailsResponse(1L, "피자", "양식" ,"피자 이미지", "피자 영상 1", "피자 영상 2", "피자 영상 3");
        given(dishService.getDishDetails(anyLong())).willReturn(dishDetailsResponse);

        // when, then
        mockMvc.perform(get("/dishes/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(dishDetailsResponse.getName()))
                .andExpect(jsonPath("$.category").value(dishDetailsResponse.getCategory()))
                .andExpect(jsonPath("$.imageUrl").value(dishDetailsResponse.getImageUrl()))
                .andExpect(jsonPath("$.videoUrl1").value(dishDetailsResponse.getVideoUrl1()))
                .andExpect(jsonPath("$.videoUrl2").value(dishDetailsResponse.getVideoUrl2()))
                .andExpect(jsonPath("$.videoUrl3").value(dishDetailsResponse.getVideoUrl3()))
                .andDo(print());
        verify(dishService, atMostOnce()).getDishDetails(1L);
    }
}