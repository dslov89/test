package com.umc.mwomeokji.domain.dish.application;

import com.umc.mwomeokji.domain.dish.dao.DishRepository;
import com.umc.mwomeokji.domain.dish.domain.Dish;
import com.umc.mwomeokji.domain.dish.dto.DishDto;
import com.umc.mwomeokji.domain.dish.dto.DishMapper;
import com.umc.mwomeokji.domain.dish.exception.NotFoundDishException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class DishServiceImplTest {

    @InjectMocks
    private DishServiceImpl dishService;

    @Mock
    private DishRepository dishRepository;

    @Spy
    @InjectMocks
    private DishMapper dishMapper = Mappers.getMapper(DishMapper.class);

    @DisplayName("모든 메뉴 이름 조회")
    @Test
    void get_all_dishes_name() {
        // given
        Dish dish1 = Dish.builder().name("마라탕").build();
        Dish dish2 = Dish.builder().name("피자").build();
        List<Dish> dishList = Stream.of(dish1, dish2).collect(Collectors.toList());
        given(dishRepository.findAll()).willReturn(dishList);

        // when
        List<DishDto.DishesNameResponse> dishesNameResponseList = dishService.getAllDishesName();

        // then
        assertThat(dishesNameResponseList).hasSize(2);
        assertThat(dishesNameResponseList).extracting("name").containsExactly("마라탕", "피자");
        then(dishRepository).should(times(1)).findAll();
    }

    @DisplayName("메뉴 상세 정보 조회 - 성공")
    @Test
    void get_dish_details() {
        // given
        Dish dish = Dish.builder()
                .name("오코노미야키")
                .imageUrl("대충 오코노미야키 이미지")
                .videoUrl1("오코노미야키 영상 1")
                .videoUrl2("오코노미야키 영상 2")
                .videoUrl3("오코노미야키 영상 3")
                .build();
        given(dishRepository.findById(anyLong())).willReturn(Optional.ofNullable(dish));

        // when
        DishDto.DishDetailsResponse dishDetailsResponse = dishService.getDishDetails(1L);

        // then
        assertThat(dishDetailsResponse.getName()).isEqualTo(dish.getName());
        assertThat(dishDetailsResponse.getImageUrl()).isEqualTo(dish.getImageUrl());
        assertThat(dishDetailsResponse.getVideoUrl1()).isEqualTo(dish.getVideoUrl1());
        assertThat(dishDetailsResponse.getVideoUrl2()).isEqualTo(dish.getVideoUrl2());
        assertThat(dishDetailsResponse.getVideoUrl3()).isEqualTo(dish.getVideoUrl3());
        then(dishRepository).should(times(1)).findById(anyLong());
    }

    @DisplayName("메뉴 상세 정보 조회 - 실패, 데이터베이스에 존재하지 않는 잘못된 id 요청")
    @Test
    void get_dish_details_fail() {
        // given
        given(dishRepository.findById(anyLong())).willReturn(Optional.empty());

        // when, then
        assertThatThrownBy(() -> dishService.getDishDetails(1L))
                .isInstanceOf(NotFoundDishException.class)
                .hasMessage("해당하는 id 의 메뉴를 찾을 수 없습니다.");
    }
}