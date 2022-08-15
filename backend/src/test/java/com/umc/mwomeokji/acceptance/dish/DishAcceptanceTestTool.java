package com.umc.mwomeokji.acceptance.dish;

import com.umc.mwomeokji.domain.dish.dish.dao.DishRepository;
import com.umc.mwomeokji.domain.dish.dish.domain.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DishAcceptanceTestTool {

    @Autowired
    private DishRepository dishRepository;

    public void saveDishes(){
        dishRepository.save(createDish("마라탕", "마라탕 이미지", "마라탕 영상 1", "마라탕 영상 2", "마라탕 영상 3"));
        dishRepository.save(createDish("궁보계정", "궁보계정 이미지", "궁보계정 영상 1", "궁보계정 영상 2", "궁보계정 영상 3"));
        dishRepository.save(createDish("까르보나라", "까르보나라 이미지", "까르보나라 영상 1", "까르보나라 영상 2", "까르보나라 영상 3"));
        dishRepository.save(createDish("오야코동", "오야코동 이미지", "오야코동 영상 1", "오야코동 영상 2", "오야코동 영상 3"));
        dishRepository.save(createDish("곱창", "곱창 이미지", "곱창 영상 1", "곱창 영상 2", "곱창 영상 3"));
    }

    private Dish createDish(String name, String imageUrl, String videoUrl1, String videoUrl2, String videoUrl3){
        return Dish.builder()
                .name(name)
                .imageUrl(imageUrl)
                .videoUrl1(videoUrl1)
                .videoUrl2(videoUrl2)
                .videoUrl3(videoUrl3).build();
    }
}
