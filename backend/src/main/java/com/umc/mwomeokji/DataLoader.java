package com.umc.mwomeokji;

import com.umc.mwomeokji.domain.QuestionDish.dao.QuestionDishRepository;
import com.umc.mwomeokji.domain.dish.dao.DishRepository;
import com.umc.mwomeokji.domain.dish.domain.Dish;
import com.umc.mwomeokji.domain.question.dao.QuestionRepository;
import com.umc.mwomeokji.domain.question.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
// @Profile("local")
public class DataLoader {

    private final DishRepository dishRepository;
    private final QuestionRepository questionRepository;
    private final QuestionDishRepository questionDishRepository;

    public void loadData() {
        dishRepository.deleteAll();
        questionRepository.deleteAll();
        questionDishRepository.deleteAll();

        // 임시 초기 메뉴리스트
        final List<Dish> dishesList = Arrays.asList(
                Dish.builder().name("쌀국수").imageUrl("쌀국수 image").videoUrl1("쌀국수 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("볶음쌀국수").imageUrl("볶음쌀국수 image").videoUrl1("볶음쌀국수 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("인도식카레").imageUrl("인도식카레 image").videoUrl1("인도식카레 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("타코").imageUrl("타코 image").videoUrl1("타코 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("포케").imageUrl("포케 image").videoUrl1("포케 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("짬뽕").imageUrl("짬뽕 image").videoUrl1("짬뽕 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("마라샹궈").imageUrl("마라샹궈 image").videoUrl1("마라샹궈 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("마라탕").imageUrl("마라탕 image").videoUrl1("마라탕 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("훠궈").imageUrl("훠궈 image").videoUrl1("훠궈 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("잔치국수").imageUrl("잔치국수 image").videoUrl1("잔치국수 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("비빔국수").imageUrl("비빔국수 image").videoUrl1("비빔국수 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("막국수(메밀국수)").imageUrl("막국수(메밀국수) image").videoUrl1("막국수(메밀국수) 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("물냉면").imageUrl("물냉면 image").videoUrl1("물냉면 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("비빔냉면").imageUrl("비빔냉면 image").videoUrl1("비빔냉면 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("밀면").imageUrl("밀면 image").videoUrl1("밀면 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("라면").imageUrl("라면 image").videoUrl1("라면 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("쫄면").imageUrl("쫄면 image").videoUrl1("쫄면 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("라멘").imageUrl("라멘 image").videoUrl1("라멘 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("우동").imageUrl("우동 image").videoUrl1("우동 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("소바").imageUrl("소바 image").videoUrl1("소바 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("파스타").imageUrl("파스타 image").videoUrl1("파스타 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("짜장면").imageUrl("짜장면 image").videoUrl1("짜장면 영상 1").videoUrl2("").videoUrl3("").build(),
                Dish.builder().name("짬뽕").imageUrl("짬뽕 image").videoUrl1("짬뽕 영상 1").videoUrl2("").videoUrl3("").build()
        );

        dishRepository.saveAll(dishesList);

        // 임시 초기 질문리스트
        final List<Question> questionList = Arrays.asList(
                Question.builder().question("혹시 멕시코, 동남아 요리 등 이색적인 메뉴는 어떠신가요?").build(),
                Question.builder().question("혹시 매운 음식은 괜찮으신가요?").build(),
                Question.builder().question("면 요리는 어떠신가요?").build()
        );

        questionRepository.saveAll(questionList);
    }
}
