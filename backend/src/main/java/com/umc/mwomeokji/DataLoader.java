package com.umc.mwomeokji;

import com.umc.mwomeokji.domain.questiondish.application.QuestionDishService;
import com.umc.mwomeokji.domain.questiondish.dao.QuestionDishRepository;
import com.umc.mwomeokji.domain.dish.dao.DishRepository;
import com.umc.mwomeokji.domain.dish.domain.Dish;
import com.umc.mwomeokji.domain.question.dao.QuestionRepository;
import com.umc.mwomeokji.domain.question.domain.Question;
import com.umc.mwomeokji.domain.questiondish.dto.QuestionDishDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
@Profile("local")
public class DataLoader {

    private final DishRepository dishRepository;
    private final QuestionRepository questionRepository;
    private final QuestionDishRepository questionDishRepository;
    private final QuestionDishService questionDishService;

    public void loadData() {
        dishRepository.deleteAll();
        questionRepository.deleteAll();
        questionDishRepository.deleteAll();

        Dish 백반 = dishRepository.save(Dish.builder().name("백반").build());
        Dish 김밥 = dishRepository.save(Dish.builder().name("김밥").build());
        Dish 비빔밥 = dishRepository.save(Dish.builder().name("비빔밥").build());
        Dish 볶음밥_한식 = dishRepository.save(Dish.builder().name("볶음밥").build());
        Dish 덮밥_한식 = dishRepository.save(Dish.builder().name("덮밥").build());
        Dish 컵밥 = dishRepository.save(Dish.builder().name("컵밥").build());
        Dish 죽 = dishRepository.save(Dish.builder().name("죽").build());
        Dish 막국수 = dishRepository.save(Dish.builder().name("막국수").build());
        Dish 비빔국수 = dishRepository.save(Dish.builder().name("비빔국수").build());
        Dish 잔치국수 = dishRepository.save(Dish.builder().name("잔치국수").build());
        Dish 칼국수 = dishRepository.save(Dish.builder().name("칼국수").build());
        Dish 물냉면 = dishRepository.save(Dish.builder().name("물냉면").build());
        Dish 비빔냉면 = dishRepository.save(Dish.builder().name("비빔냉면").build());
        Dish 밀면 = dishRepository.save(Dish.builder().name("밀면").build());
        Dish 떡갈비 = dishRepository.save(Dish.builder().name("떡갈비").build());
        Dish 불고기 = dishRepository.save(Dish.builder().name("불고기").build());
        Dish 소갈비 = dishRepository.save(Dish.builder().name("소갈비").build());
        Dish 삼겹살 = dishRepository.save(Dish.builder().name("삼겹살").build());
        Dish 제육볶음 = dishRepository.save(Dish.builder().name("제육볶음").build());
        Dish 보쌈= dishRepository.save(Dish.builder().name("보쌈").build());
        Dish 순대= dishRepository.save(Dish.builder().name("순대").build());
        Dish 족발 = dishRepository.save(Dish.builder().name("족발").build());
        Dish 닭갈비 = dishRepository.save(Dish.builder().name("닭갈비").build());
        Dish 곱창 = dishRepository.save(Dish.builder().name("곱창").build());
        Dish 치킨 = dishRepository.save(Dish.builder().name("치킨").build());
        Dish 닭발= dishRepository.save(Dish.builder().name("닭발").build());
        Dish 게장 = dishRepository.save(Dish.builder().name("게장").build());
        Dish 생선찜 = dishRepository.save(Dish.builder().name("생선찜").build());
        Dish 생선구이 = dishRepository.save(Dish.builder().name("생선구이").build());
        Dish 조개구이 = dishRepository.save(Dish.builder().name("조개구이").build());
        Dish 회덮밥 = dishRepository.save(Dish.builder().name("회덮밥").build());
        Dish 물회 = dishRepository.save(Dish.builder().name("물회").build());
        Dish 전 = dishRepository.save(Dish.builder().name("전").build());
        Dish 국밥 = dishRepository.save(Dish.builder().name("국밥").build());
        Dish 떡국 = dishRepository.save(Dish.builder().name("떡국").build());
        Dish 수제비 = dishRepository.save(Dish.builder().name("수제비").build());
        Dish 갈비탕 = dishRepository.save(Dish.builder().name("갈비탕").build());
        Dish 감자탕 = dishRepository.save(Dish.builder().name("감자탕").build());
        Dish 닭도리탕 = dishRepository.save(Dish.builder().name("닭도리탕").build());
        Dish 매운탕 = dishRepository.save(Dish.builder().name("매운탕").build());
        Dish 삼계탕 = dishRepository.save(Dish.builder().name("삼계탕").build());
        Dish 김치찌개 = dishRepository.save(Dish.builder().name("김치찌개").build());
        Dish 된장찌개 = dishRepository.save(Dish.builder().name("된장찌개").build());
        Dish 순두부찌개 = dishRepository.save(Dish.builder().name("순두부찌개").build());
        Dish 부대찌개 = dishRepository.save(Dish.builder().name("부대찌개").build());
        Dish 떡볶이 = dishRepository.save(Dish.builder().name("떡볶이").build());
        Dish 라면 = dishRepository.save(Dish.builder().name("라면").build());
        Dish 쫄면 = dishRepository.save(Dish.builder().name("쫄면").build());
        Dish 튀김_분식 = dishRepository.save(Dish.builder().name("튀김").build());
        Dish 샤부샤부 = dishRepository.save(Dish.builder().name("샤부샤부").build());
        Dish 초밥 = dishRepository.save(Dish.builder().name("초밥").build());
        Dish 돈부리 = dishRepository.save(Dish.builder().name("돈부리").build());
        Dish 돈가스 = dishRepository.save(Dish.builder().name("돈가스").build());
        Dish 사시미 = dishRepository.save(Dish.builder().name("사시미").build());
        Dish 오코노미야끼 = dishRepository.save(Dish.builder().name("오코노미야끼").build());
        Dish 타코야끼 = dishRepository.save(Dish.builder().name("타코야끼").build());
        Dish 고로케 = dishRepository.save(Dish.builder().name("고로케").build());
        Dish 라멘 = dishRepository.save(Dish.builder().name("라멘").build());
        Dish 우동 = dishRepository.save(Dish.builder().name("우동").build());
        Dish 냉소바 = dishRepository.save(Dish.builder().name("냉소바").build());
        Dish 나가사키짬뽕 = dishRepository.save(Dish.builder().name("나가사키짬뽕").build());
        Dish 리조또 = dishRepository.save(Dish.builder().name("리조또").build());
        Dish 필라프 = dishRepository.save(Dish.builder().name("필라프").build());
        Dish 스테이크 = dishRepository.save(Dish.builder().name("스테이크").build());
        Dish 바비큐 = dishRepository.save(Dish.builder().name("바비큐").build());
        Dish 그라탕 = dishRepository.save(Dish.builder().name("그라탕").build());
        Dish 피자 = dishRepository.save(Dish.builder().name("피자").build());
        Dish 감바스 = dishRepository.save(Dish.builder().name("감바스").build());
        Dish 토스트 = dishRepository.save(Dish.builder().name("토스트").build());
        Dish 핫도그 = dishRepository.save(Dish.builder().name("핫도그").build());
        Dish 샌드위치 = dishRepository.save(Dish.builder().name("샌드위치").build());
        Dish 햄버거 = dishRepository.save(Dish.builder().name("햄버거").build());
        Dish 파스타 = dishRepository.save(Dish.builder().name("파스타").build());
        Dish 짜장면 = dishRepository.save(Dish.builder().name("짜장면").build());
        Dish 짬뽕 = dishRepository.save(Dish.builder().name("짬뽕").build());
        // Dish 우동_중식 = dishRepository.save(Dish.builder().name("우동").build()); -> 나 진짜 처음들어보는데 중국음식점에 우동을 먹으러 가 본 사람 있어?
        Dish 볶음밥_중식 = dishRepository.save(Dish.builder().name("볶음밥").build());
        Dish 짜장밥 = dishRepository.save(Dish.builder().name("짜장밥").build());
        Dish 짬뽕밥 = dishRepository.save(Dish.builder().name("짬뽕밥").build());
        Dish 잡채밥 = dishRepository.save(Dish.builder().name("잡채밥").build());
        Dish 마파두부 = dishRepository.save(Dish.builder().name("마파두부").build());
        Dish 탕수육 = dishRepository.save(Dish.builder().name("탕수육(사이드)").build());
        Dish 깐풍기 = dishRepository.save(Dish.builder().name("깐풍기(사이드)").build());
        Dish 유린기 = dishRepository.save(Dish.builder().name("유린기(사이드)").build());
        Dish 군만두 = dishRepository.save(Dish.builder().name("군만두(사이드)").build());
        // Dish 물만두 = dishRepository.save(Dish.builder().name("물만두").build()); -> 일단 스프레드시트 답변 대기
        Dish 깐풍새우 = dishRepository.save(Dish.builder().name("깐풍새우").build());
        Dish 깐쇼새우 = dishRepository.save(Dish.builder().name("깐쇼새우").build());
        Dish 마라샹궈 = dishRepository.save(Dish.builder().name("마라샹궈").build());
        Dish 마라탕 = dishRepository.save(Dish.builder().name("마라탕").build());
        Dish 훠궈 = dishRepository.save(Dish.builder().name("훠궈").build());
        Dish 꿔바로우 = dishRepository.save(Dish.builder().name("꿔바로우").build());
        Dish 양꼬치 = dishRepository.save(Dish.builder().name("양꼬치").build());
        Dish 쌀국수 = dishRepository.save(Dish.builder().name("쌀국수").build());
        Dish 볶음쌀국수 = dishRepository.save(Dish.builder().name("볶음쌀국수").build());
        Dish 인도식카레 = dishRepository.save(Dish.builder().name("인도식카레").build());
        Dish 타코 = dishRepository.save(Dish.builder().name("타코").build());
        Dish 부리또 = dishRepository.save(Dish.builder().name("부리또").build());
        Dish 포케 = dishRepository.save(Dish.builder().name("포케").build());
        Dish 샐러드 = dishRepository.save(Dish.builder().name("샐러드").build());
        Dish 찜닭 = dishRepository.save(Dish.builder().name("찜닭").build());
        Dish 그릭요거트 = dishRepository.save(Dish.builder().name("그릭요거트").build());
        Dish 야끼소바 = dishRepository.save(Dish.builder().name("야끼소바").build());

        Question 질문1 = questionRepository.save(Question.builder().question("기름진 음식은 어떠신가요?").build());
        Question 질문2 = questionRepository.save(Question.builder().question("간단한 식사는 어떠신가요? ").build());
        Question 질문3 = questionRepository.save(Question.builder().question("혹시 멕시코, 동남아 요리 등 이색적인 메뉴는 어떠신가요?").build());
        Question 질문4 = questionRepository.save(Question.builder().question("혹시 매운 음식은 괜찮으신가요?").build());
        Question 질문5 = questionRepository.save(Question.builder().question("면 요리는 어떠신가요?").build());
        Question 질문6 = questionRepository.save(Question.builder().question("튀김요리는 어떠신가요?").build());
        Question 질문7 = questionRepository.save(Question.builder().question("탕이나 맑은 국물 요리는 어떠신가요?").build());
        Question 질문8 = questionRepository.save(Question.builder().question("달달한 거 좋아하시나요?").build());
        Question 질문9 = questionRepository.save(Question.builder().question("비싼 음식을 드시고 싶으신가요?").build());
        Question 질문10 = questionRepository.save(Question.builder().question("빨리 드셔야 하나요?").build());

        List<Long> dishesIds1 = Arrays.asList(떡갈비.getId(), 소갈비.getId(), 삼겹살.getId(), 족발.getId(), 보쌈.getId(), 곱창.getId(),
                치킨.getId(), 전.getId(), 돈가스.getId(), 라멘.getId(), 피자.getId(), 감바스.getId(), 짜장면.getId(), 짬뽕.getId(), 볶음밥_중식.getId(),
                짜장밥.getId(), 짬뽕밥.getId(), 탕수육.getId(), 깐풍기.getId(), 유린기.getId(), 군만두.getId(), 깐풍새우.getId(), 깐쇼새우.getId(),
                꿔바로우.getId());
        List<Long> dishesIds2 = Arrays.asList(김밥.getId(), 컵밥.getId(), 죽.getId(), 떡볶이.getId(), 잔치국수.getId(), 볶음밥_한식.getId(),
                떡볶이.getId(), 라면.getId(), 쫄면.getId(), 초밥.getId(), 고로케.getId(), 우동.getId(), 냉소바.getId(), 물냉면.getId(),
                토스트.getId(), 핫도그.getId(), 부리또.getId(), 포케.getId(), 샐러드.getId(), 그릭요거트.getId());
        List<Long> dishesIds3 = Arrays.asList(쌀국수.getId(), 볶음쌀국수.getId(), 인도식카레.getId(), 타코.getId(), 포케.getId(), 부리또.getId());
        List<Long> dishesIds4 = Arrays.asList(나가사키짬뽕.getId(), 짬뽕.getId(), 짬뽕밥.getId(), 마라샹궈.getId(), 마라탕.getId(), 훠궈.getId());
        List<Long> dishesIds5 = Arrays.asList(비빔국수.getId(), 잔치국수.getId(), 칼국수.getId(), 물냉면.getId(), 비빔냉면.getId(),
                밀면.getId(), 라면.getId(), 쫄면.getId(), 라멘.getId(), 우동.getId(), 냉소바.getId(), 나가사키짬뽕.getId(), 파스타.getId(),
                짜장면.getId(), 짬뽕.getId(), 쌀국수.getId(), 볶음쌀국수.getId(), 야끼소바.getId());
        List<Long> dishesIds6 = Arrays.asList(돈가스.getId(), 탕수육.getId(), 깐풍기.getId(), 유린기.getId());
        List<Long> dishesIds7 = Arrays.asList(국밥.getId(), 떡국.getId(), 수제비.getId(), 갈비탕.getId(), 삼계탕.getId(), 샤부샤부.getId(), 쌀국수.getId());
        List<Long> dishesIds8 = Arrays.asList(떡볶이.getId(),토스트.getId(),핫도그.getId(),샌드위치.getId());
        List<Long> dishesIds9 = Arrays.asList(떡갈비.getId(), 불고기.getId(), 소갈비.getId(), 삼겹살.getId(),  보쌈.getId(), 족발.getId(), 곱창.getId(),
                치킨.getId(), 닭발.getId(), 게장.getId(), 생선찜.getId(), 생선구이.getId(), 조개구이.getId(), 감자탕.getId(), 삼계탕.getId(), 스테이크.getId(),
                바비큐.getId(), 파스타.getId(), 깐풍새우.getId(), 깐쇼새우.getId());
        List<Long> dishesIds10 = Arrays.asList(백반.getId(), 김밥.getId(), 비빔밥.getId(), 컵밥.getId(), 잔치국수.getId(), 비빔국수.getId(), 잔치국수.getId(),
                물냉면.getId(), 비빔냉면.getId(), 국밥.getId(), 떡볶이.getId(), 라면.getId(), 쫄면.getId(), 타코야끼.getId(), 고로케.getId(), 우동.getId(),
                냉소바.getId(), 토스트.getId(), 핫도그.getId(), 샌드위치.getId(), 햄버거.getId(), 짜장면.getId(), 짬뽕.getId(), 우동.getId(), 볶음밥_중식.getId(),
                짜장밥.getId(), 짬뽕밥.getId(), 마라탕.getId(), 샐러드.getId());

        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문1.getId(), dishesIds1));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문2.getId(), dishesIds2));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문3.getId(), dishesIds3));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문4.getId(), dishesIds4));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문5.getId(), dishesIds5));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문6.getId(), dishesIds6));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문7.getId(), dishesIds7));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문8.getId(), dishesIds8));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문9.getId(), dishesIds9));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문10.getId(), dishesIds10));
    }
}
