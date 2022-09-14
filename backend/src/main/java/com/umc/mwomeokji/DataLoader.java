package com.umc.mwomeokji;

import com.umc.mwomeokji.domain.dish.category.dao.CategoryRepository;
import com.umc.mwomeokji.domain.dish.category.domain.Category;
import com.umc.mwomeokji.domain.questiondish.application.QuestionDishService;
import com.umc.mwomeokji.domain.questiondish.dao.QuestionDishRepository;
import com.umc.mwomeokji.domain.dish.dish.dao.DishRepository;
import com.umc.mwomeokji.domain.dish.dish.domain.Dish;
import com.umc.mwomeokji.domain.question.dao.QuestionRepository;
import com.umc.mwomeokji.domain.question.domain.Question;
import com.umc.mwomeokji.domain.questiondish.dto.QuestionDishDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${cloud.aws.cloudfront.url}")
    private String cloudfrontImageUrlFormat;

    private final CategoryRepository categoryRepository;
    private final DishRepository dishRepository;
    private final QuestionRepository questionRepository;
    private final QuestionDishRepository questionDishRepository;
    private final QuestionDishService questionDishService;

    public void loadData() {
        categoryRepository.deleteAll();
        dishRepository.deleteAll();
        questionRepository.deleteAll();
        questionDishRepository.deleteAll();

        Category 일식 = Category.builder().category("일식").build();
        Category 양식 = Category.builder().category("양식").build();
        Category 한식 = Category.builder().category("한식").build();
        Category 중식 = Category.builder().category("중식").build();
        Category 기타 = Category.builder().category("기타").build();

        List<Category> categoriesList = Arrays.asList(일식, 양식, 한식, 중식, 기타);
        categoryRepository.saveAll(categoriesList);

        Dish 백반 = Dish.builder().name("백반").category(한식).imageUrl(createFilePath("백반")).build();
        Dish 김밥 = Dish.builder().name("김밥").category(한식).imageUrl(createFilePath("김밥")).build();
        Dish 비빔밥 = Dish.builder().name("비빔밥").category(한식).imageUrl(createFilePath("비빔밥")).build();
        Dish 볶음밥_한식 = Dish.builder().name("볶음밥").category(한식).imageUrl(createFilePath("볶음밥_한식")).build();
        Dish 덮밥 = Dish.builder().name("덮밥").category(한식).imageUrl(createFilePath("덮밥")).build();
        Dish 컵밥 = Dish.builder().name("컵밥").category(한식).imageUrl(createFilePath("컵밥")).build();
        Dish 죽 = Dish.builder().name("죽").category(한식).imageUrl(createFilePath("죽")).build();
        Dish 메밀국수 = Dish.builder().name("메밀국수").category(한식).imageUrl(createFilePath("메밀국수")).build();
        Dish 비빔국수 = Dish.builder().name("비빔국수").category(한식).imageUrl(createFilePath("비빔국수")).build();
        Dish 잔치국수 = Dish.builder().name("잔치국수").category(한식).imageUrl(createFilePath("잔치국수")).build();
        Dish 칼국수 = Dish.builder().name("칼국수").category(한식).imageUrl(createFilePath("칼국수")).build();
        Dish 물냉면 = Dish.builder().name("물냉면").category(한식).imageUrl(createFilePath("물냉면")).build();
        Dish 비빔냉면 = Dish.builder().name("비빔냉면").category(한식).imageUrl(createFilePath("비빔냉면")).build();
        Dish 밀면 = Dish.builder().name("밀면").category(한식).imageUrl(createFilePath("밀면")).build();
        Dish 떡갈비 = Dish.builder().name("떡갈비").category(한식).imageUrl(createFilePath("떡갈비")).build();
        Dish 불고기 = Dish.builder().name("불고기").category(한식).imageUrl(createFilePath("불고기")).build();
        Dish 소갈비 = Dish.builder().name("소갈비").category(한식).imageUrl(createFilePath("소갈비")).build();
        Dish 삼겹살 = Dish.builder().name("삼겹살").category(한식).imageUrl(createFilePath("삼겹살")).build();
        Dish 제육볶음 = Dish.builder().name("제육볶음").category(한식).imageUrl(createFilePath("제육볶음")).build();
        Dish 보쌈= Dish.builder().name("보쌈").category(한식).imageUrl(createFilePath("보쌈")).build();
        Dish 순대= Dish.builder().name("순대").category(한식).imageUrl(createFilePath("순대")).build();
        Dish 족발 = Dish.builder().name("족발").category(한식).imageUrl(createFilePath("족발")).build();
        Dish 찜닭 = Dish.builder().name("찜닭").category(한식).imageUrl(createFilePath("찜닭")).build();
        Dish 닭갈비 = Dish.builder().name("닭갈비").category(한식).imageUrl(createFilePath("닭갈비")).build();
        Dish 곱창 = Dish.builder().name("곱창").category(한식).imageUrl(createFilePath("곱창")).build();
        Dish 치킨 = Dish.builder().name("치킨").category(한식).imageUrl(createFilePath("치킨")).build();
        Dish 닭발 = Dish.builder().name("닭발").category(한식).imageUrl(createFilePath("닭발")).build();
        Dish 육회 = Dish.builder().name("육회").category(한식).imageUrl(createFilePath("육회")).build();
        Dish 만두 = Dish.builder().name("만두").category(한식).imageUrl(createFilePath("만두")).build();
        Dish 게장 = Dish.builder().name("게장").category(한식).imageUrl(createFilePath("게장")).build();
        Dish 생선찜 = Dish.builder().name("생선찜").category(한식).imageUrl(createFilePath("생선찜")).build();
        Dish 생선구이 = Dish.builder().name("생선구이").category(한식).imageUrl(createFilePath("생선구이")).build();
        Dish 조개구이 = Dish.builder().name("조개구이").category(한식).imageUrl(createFilePath("조개구이")).build();
        Dish 회덮밥 = Dish.builder().name("회덮밥").category(한식).imageUrl(createFilePath("회덮밥")).build();
        Dish 물회 = Dish.builder().name("물회").category(한식).imageUrl(createFilePath("물회")).build();
        Dish 전 = Dish.builder().name("전").category(한식).imageUrl(createFilePath("전")).build();
        Dish 국밥 = Dish.builder().name("국밥").category(한식).imageUrl(createFilePath("국밥")).build();
        Dish 떡국 = Dish.builder().name("떡국").category(한식).imageUrl(createFilePath("떡국")).build();
        Dish 수제비 = Dish.builder().name("수제비").category(한식).imageUrl(createFilePath("수제비")).build();
        Dish 갈비탕 = Dish.builder().name("갈비탕").category(한식).imageUrl(createFilePath("갈비탕")).build();
        Dish 감자탕 = Dish.builder().name("감자탕").category(한식).imageUrl(createFilePath("감자탕")).build();
        Dish 닭도리탕 = Dish.builder().name("닭도리탕").category(한식).imageUrl(createFilePath("닭도리탕")).build();
        Dish 매운탕 = Dish.builder().name("매운탕").category(한식).imageUrl(createFilePath("매운탕")).build();
        Dish 삼계탕 = Dish.builder().name("삼계탕").category(한식).imageUrl(createFilePath("삼계탕")).build();
        Dish 김치찌개 = Dish.builder().name("김치찌개").category(한식).imageUrl(createFilePath("김치찌개")).build();
        Dish 된장찌개 = Dish.builder().name("된장찌개").category(한식).imageUrl(createFilePath("된장찌개")).build();
        Dish 순두부찌개 = Dish.builder().name("순두부찌개").category(한식).imageUrl(createFilePath("순두부찌개")).build();
        Dish 부대찌개 = Dish.builder().name("부대찌개").category(한식).imageUrl(createFilePath("부대찌개")).build();
        Dish 떡볶이_쌀떡 = Dish.builder().name("떡볶이(밀떡)").category(한식).imageUrl(createFilePath("떡볶이(밀떡)")).build();
        Dish 떡볶이_밀떡 = Dish.builder().name("떡볶이(쌀떡)").category(한식).imageUrl(createFilePath("떡볶이(쌀떡)")).build();
        Dish 라면 = Dish.builder().name("라면").category(한식).imageUrl(createFilePath("라면")).build();
        Dish 쫄면 = Dish.builder().name("쫄면").category(한식).imageUrl(createFilePath("쫄면")).build();
        Dish 튀김_분식 = Dish.builder().name("튀김(분식)").category(한식).imageUrl(createFilePath("튀김(분식)")).build();
        Dish 샤브샤브 = Dish.builder().name("샤브샤브").category(일식).imageUrl(createFilePath("샤브샤브")).build();
        Dish 초밥 = Dish.builder().name("초밥").category(일식).imageUrl(createFilePath("초밥")).build();
        Dish 돈부리 = Dish.builder().name("돈부리").category(일식).imageUrl(createFilePath("돈부리")).build();
        Dish 돈가스 = Dish.builder().name("돈가스").category(일식).imageUrl(createFilePath("돈가스")).build();
        Dish 사시미 = Dish.builder().name("사시미").category(일식).imageUrl(createFilePath("사시미")).build();
        Dish 오코노미야끼 = Dish.builder().name("오코노미야끼").category(일식).imageUrl(createFilePath("오코노미야끼")).build();
        Dish 타코야끼 = Dish.builder().name("타코야끼").category(일식).imageUrl(createFilePath("타코야끼")).build();
        Dish 고로케 = Dish.builder().name("고로케").category(일식).imageUrl(createFilePath("고로케")).build();
        Dish 야끼소바 = Dish.builder().name("야끼소바").category(일식).imageUrl(createFilePath("야끼소바")).build();
        Dish 라멘 = Dish.builder().name("라멘").category(일식).imageUrl(createFilePath("라멘")).build();
        Dish 우동 = Dish.builder().name("우동").category(일식).imageUrl(createFilePath("우동")).build();
        Dish 냉소바 = Dish.builder().name("냉소바").category(일식).imageUrl(createFilePath("냉소바")).build();
        Dish 나가사키짬뽕 = Dish.builder().name("나가사키짬뽕").category(일식).imageUrl(createFilePath("나가사키짬뽕")).build();
        Dish 리조또 = Dish.builder().name("리조또").category(양식).imageUrl(createFilePath("리조또")).build();
        Dish 필라프 = Dish.builder().name("필라프").category(양식).imageUrl(createFilePath("필라프")).build();
        Dish 스테이크 = Dish.builder().name("스테이크").category(양식).imageUrl(createFilePath("스테이크")).build();
        Dish 바비큐 = Dish.builder().name("바비큐").category(양식).imageUrl(createFilePath("바비큐")).build();
        Dish 그라탕 = Dish.builder().name("그라탕").category(양식).imageUrl(createFilePath("그라탕")).build();
        Dish 피자 = Dish.builder().name("피자").category(양식).imageUrl(createFilePath("피자")).build();
        Dish 감바스 = Dish.builder().name("감바스").category(양식).imageUrl(createFilePath("감바스")).build();
        Dish 토스트 = Dish.builder().name("토스트").category(양식).imageUrl(createFilePath("토스트")).build();
        Dish 핫도그 = Dish.builder().name("핫도그").category(양식).imageUrl(createFilePath("핫도그")).build();
        Dish 샌드위치 = Dish.builder().name("샌드위치").category(양식).imageUrl(createFilePath("샌드위치")).build();
        Dish 햄버거 = Dish.builder().name("햄버거").category(양식).imageUrl(createFilePath("햄버거")).build();
        Dish 파스타 = Dish.builder().name("파스타").category(양식).imageUrl(createFilePath("파스타")).build();
        Dish 짜장면 = Dish.builder().name("짜장면").category(중식).imageUrl(createFilePath("짜장면")).build();
        Dish 짬뽕 = Dish.builder().name("짬뽕").category(중식).imageUrl(createFilePath("짬뽕")).build();
        Dish 볶음밥_중식 = Dish.builder().name("볶음밥").category(중식).imageUrl(createFilePath("볶음밥")).build();
        Dish 짜장밥 = Dish.builder().name("짜장밥").category(중식).imageUrl(createFilePath("짜장밥")).build();
        Dish 짬뽕밥 = Dish.builder().name("짬뽕밥").category(중식).imageUrl(createFilePath("짬뽕밥")).build();
        Dish 잡채밥 = Dish.builder().name("잡채밥").category(중식).imageUrl(createFilePath("잡채밥")).build();
        Dish 마파두부 = Dish.builder().name("마파두부").category(중식).imageUrl(createFilePath("마파두부")).build();
        Dish 탕수육 = Dish.builder().name("탕수육").category(중식).imageUrl(createFilePath("탕수육")).build();
        Dish 깐풍기 = Dish.builder().name("깐풍기").category(중식).imageUrl(createFilePath("깐풍기")).build();
        Dish 유린기 = Dish.builder().name("유린기").category(중식).imageUrl(createFilePath("유린기")).build();
        Dish 꿔바로우 = Dish.builder().name("꿔바로우").category(중식).imageUrl(createFilePath("꿔바로우")).build();
        Dish 군만두 = Dish.builder().name("군만두").category(중식).imageUrl(createFilePath("군만두")).build();
        Dish 물만두 = Dish.builder().name("물만두").category(중식).imageUrl(createFilePath("물만두")).build();
        Dish 딤섬 = Dish.builder().name("딤섬").category(중식).imageUrl(createFilePath("딤섬")).build();
        Dish 양꼬치 = Dish.builder().name("양꼬치").category(중식).imageUrl(createFilePath("양꼬치")).build();
        Dish 깐풍새우 = Dish.builder().name("깐풍새우").category(중식).imageUrl(createFilePath("깐풍새우")).build();
        Dish 깐쇼새우 = Dish.builder().name("깐쇼새우").category(중식).imageUrl(createFilePath("깐쇼새우")).build();
        Dish 마라샹궈 = Dish.builder().name("마라샹궈").category(중식).imageUrl(createFilePath("마라샹궈")).build();
        Dish 마라탕 = Dish.builder().name("마라탕").category(중식).imageUrl(createFilePath("마라탕")).build();
        Dish 훠궈 = Dish.builder().name("훠궈").category(중식).imageUrl(createFilePath("훠궈")).build();
        Dish 쌀국수 = Dish.builder().name("쌀국수").category(기타).imageUrl(createFilePath("쌀국수")).build();
        Dish 볶음쌀국수 = Dish.builder().name("볶음쌀국수").category(기타).imageUrl(createFilePath("볶음쌀국수")).build();
        Dish 인도식카레 = Dish.builder().name("인도식카레").category(기타).imageUrl(createFilePath("인도식카레")).build();
        Dish 타코 = Dish.builder().name("타코").category(양식).imageUrl(createFilePath("타코")).build();
        Dish 부리또 = Dish.builder().name("부리또").category(양식).imageUrl(createFilePath("부리또")).build();
        Dish 포케 = Dish.builder().name("포케").category(양식).imageUrl(createFilePath("포케")).build();
        Dish 샐러드 = Dish.builder().name("샐러드").category(양식).imageUrl(createFilePath("샐러드")).build();
        Dish 돼지갈비찜 = Dish.builder().name("돼지갈비찜").category(양식).imageUrl(createFilePath("돼지갈비찜")).build();
        Dish 등갈비김치찜 = Dish.builder().name("등갈비김치찜").category(양식).imageUrl(createFilePath("등갈비김치찜")).build();
        Dish 고추장찌개 = Dish.builder().name("고추장찌개").category(양식).imageUrl(createFilePath("고추장찌개")).build();
        Dish 차돌박이김치찌개 = Dish.builder().name("차돌박이김치찌개").category(양식).imageUrl(createFilePath("차돌박이김치찌개")).build();

        List<Dish> dishesList = Arrays.asList(
                백반, 김밥, 비빔밥, 볶음밥_한식, 덮밥, 컵밥, 죽, 메밀국수, 비빔국수, 잔치국수, 칼국수, 물냉면, 비빔냉면, 밀면, 떡갈비,
                불고기, 소갈비, 삼겹살, 제육볶음, 보쌈, 순대, 족발, 찜닭, 닭갈비, 곱창, 치킨, 닭발, 육회, 만두, 게장, 생선찜, 생선구이, 조개구이,
                회덮밥, 물회, 전, 국밥, 떡국, 수제비, 갈비탕, 감자탕, 닭도리탕, 매운탕, 삼계탕, 김치찌개, 된장찌개, 순두부찌개, 부대찌개,
                떡볶이_쌀떡, 떡볶이_밀떡, 라면, 쫄면, 튀김_분식, 샤브샤브, 초밥, 돈부리, 돈가스, 사시미, 오코노미야끼, 타코야끼, 고로케, 야끼소바,
                라멘, 우동, 냉소바, 나가사키짬뽕, 리조또, 필라프, 스테이크, 바비큐, 그라탕, 피자, 감바스, 토스트, 핫도그, 샌드위치, 햄버거, 파스타,
                짜장면, 짬뽕, 볶음밥_중식, 짜장밥, 짬뽕밥, 잡채밥, 마파두부, 탕수육, 깐풍기, 유린기, 꿔바로우, 군만두, 물만두, 딤섬, 양꼬치,
                깐풍새우, 깐쇼새우, 마라샹궈, 마라탕, 훠궈, 쌀국수, 볶음쌀국수, 인도식카레, 타코, 부리또, 포케, 샐러드, 돼지갈비찜,
                등갈비김치찜, 고추장찌개, 차돌박이김치찌개
        );

        dishRepository.saveAll(dishesList);

        Question 질문1 = Question.builder().question("한식을 좋아하시나요?").build();
        Question 질문2 = Question.builder().question("고기 쪽은 어떠신가요?").build();
        Question 질문3 = Question.builder().question("해장이 필요하신가요?").build();
        Question 질문4 = Question.builder().question("따뜻한 음식을 좋아하시나요?").build();
        Question 질문5 = Question.builder().question("술과 어울리는 음식을 드시고 싶으신가요?").build();
        Question 질문6 = Question.builder().question("밀가루 들어간 음식도 괜찮으신가요?").build();
        Question 질문7 = Question.builder().question("야식으로 드시나요?").build();
        Question 질문8 = Question.builder().question("날 것도 괜찮으신가요?").build();
        Question 질문9 = Question.builder().question("다이어트를 하시나요?").build();
        Question 질문10 = Question.builder().question("보양식을 드시고 싶으신가요?").build();
        Question 질문11 = Question.builder().question("시원한 음식을 먹고 싶나요?").build();
        Question 질문12 = Question.builder().question("분식 종류는 어떠신가요?").build();
        Question 질문13 = Question.builder().question("찌개류는 어떠신가요?").build();
        Question 질문14 = Question.builder().question("찜류 요리를 드시고 싶나요?").build();
        Question 질문15 = Question.builder().question("닭 요리는 어떠신가요?").build();
        Question 질문16 = Question.builder().question("기름진 음식은 어떠신가요?").build();
        Question 질문17 = Question.builder().question("간단한 식사는 어떠신가요? ").build();
        Question 질문18 = Question.builder().question("혹시 멕시코, 동남아 요리 등 이색적인 메뉴는 어떠신가요?").build();
        Question 질문19 = Question.builder().question("혹시 매운 음식은 괜찮으신가요?").build();
        Question 질문20 = Question.builder().question("면 요리는 어떠신가요?").build();
        Question 질문21 = Question.builder().question("튀김요리는 어떠신가요?").build();
        Question 질문22 = Question.builder().question("탕이나 맑은 국물 요리는 어떠신가요?").build();
        Question 질문23 = Question.builder().question("달달한 거 좋아하시나요?").build();
        Question 질문24 = Question.builder().question("비싼 음식을 드시고 싶으신가요?").build();
        Question 질문25 = Question.builder().question("빨리 드셔야 하나요?").build();
        Question 질문26 = Question.builder().question("만들어 먹고 싶으신가요?").build();
        Question 질문27 = Question.builder().question("건강식을 먹고 싶으신가요?").build();
        Question 질문28 = Question.builder().question("혼자 드시나요?").build();
        Question 질문29 = Question.builder().question("비가 오나요?").build();
        Question 질문30 = Question.builder().question("오늘 특별한 날인가요?").build();
        Question 질문31 = Question.builder().question("함께 가는 인원이 많나요?").build();
        Question 질문32 = Question.builder().question("든든하게 먹고 싶나요?").build();
        Question 질문33 = Question.builder().question("새콤한게 땡기시나요?").build();
        Question 질문34 = Question.builder().question("향신료 있는 음식도 괜찮나요?").build();
        Question 질문35 = Question.builder().question("호불호 없는 음식으로 좋아하시나요?").build();
        Question 질문36 = Question.builder().question("가족들과 같이 식사하나요?").build();
        Question 질문37 = Question.builder().question("일본식 음식을 좋아하시나요?").build();
        Question 질문38 = Question.builder().question("자주 시키는(가는) 근처 중국집이 있으신가요?").build();
        Question 질문39 = Question.builder().question("기분이 꿀꿀하신가요?").build();
        Question 질문40 = Question.builder().question("가성비를 중요시하나요?").build();
        Question 질문41 = Question.builder().question("지금 많이 더운가요? (이열치열 동의하시나요?)").build();
        Question 질문42 = Question.builder().question("지금 많이 추운가요? (얼죽아 어떻게 생각하시나요?)").build();
        Question 질문43 = Question.builder().question("빨간음식이 생각나시나요?").build();
        Question 질문44 = Question.builder().question("비건이신가요?").build();
        Question 질문45 = Question.builder().question("깔끔하게 먹을 수 있는 음식이 필요하신가요?").build();

        List<Question> questionsList = Arrays.asList(
                질문1, 질문2, 질문3, 질문4, 질문5, 질문6, 질문7, 질문8, 질문9, 질문10, 질문11, 질문12, 질문13, 질문14, 질문15, 질문16,
                질문17, 질문18, 질문19, 질문20, 질문21, 질문22, 질문23, 질문24, 질문25, 질문26, 질문27, 질문28, 질문29, 질문30,
                질문31, 질문32, 질문33, 질문34, 질문35, 질문36, 질문37, 질문38, 질문39, 질문40, 질문41, 질문42, 질문43, 질문44, 질문45
        );

        questionRepository.saveAll(questionsList);

        List<Long> dishesIds1 = Arrays.asList(
                백반.getId(), 김밥.getId(), 비빔밥.getId(), 볶음밥_한식.getId(), 덮밥.getId(), 컵밥.getId(), 죽.getId(),
                메밀국수.getId(), 비빔국수.getId(), 잔치국수.getId(), 칼국수.getId(), 물냉면.getId(), 비빔냉면.getId(),
                밀면.getId(), 떡갈비.getId(), 불고기.getId(), 소갈비.getId(), 삼겹살.getId(), 제육볶음.getId(), 보쌈.getId(),
                순대.getId(), 족발.getId(), 찜닭.getId(), 닭갈비.getId(), 곱창.getId(), 치킨.getId(), 닭발.getId(),
                육회.getId(), 만두.getId(), 게장.getId(), 생선찜.getId(), 생선구이.getId(), 조개구이.getId(), 회덮밥.getId(),
                물회.getId(), 전.getId(), 국밥.getId(), 떡국.getId(), 수제비.getId(), 갈비탕.getId(), 감자탕.getId(),
                닭도리탕.getId(), 매운탕.getId(), 삼계탕.getId(), 김치찌개.getId(), 된장찌개.getId(), 순두부찌개.getId(),
                부대찌개.getId(), 떡볶이_쌀떡.getId(), 떡볶이_밀떡.getId(), 라면.getId(), 쫄면.getId(), 튀김_분식.getId()
        );
        List<Long> dishesIds2 = Arrays.asList(
                떡갈비.getId(), 불고기.getId(), 소갈비.getId(), 삼겹살.getId(), 제육볶음.getId(), 보쌈.getId(), 순대.getId(),
                족발.getId(), 찜닭.getId(), 닭갈비.getId(), 곱창.getId(), 치킨.getId(), 닭발.getId(), 육회.getId(),
                스테이크.getId(), 바비큐.getId(), 탕수육.getId(), 깐풍기.getId(), 유린기.getId(), 꿔바로우.getId(), 군만두.getId(),
                물만두.getId(), 딤섬.getId(), 양꼬치.getId()
        );
        List<Long> dishesIds3 = Arrays.asList(
                국밥.getId(), 칼국수.getId(), 떡국.getId(), 수제비.getId(), 갈비탕.getId(), 감자탕.getId(), 김치찌개.getId(),
                순두부찌개.getId(), 라면.getId(), 짬뽕.getId()
        );
        List<Long> dishesIds4 = Arrays.asList(
                메밀국수.getId(), 잔치국수.getId(), 칼국수.getId(), 국밥.getId(), 떡국.getId(), 수제비.getId(), 갈비탕.getId(),
                감자탕.getId(), 닭도리탕.getId(), 매운탕.getId(), 삼계탕.getId(), 김치찌개.getId(), 된장찌개.getId(), 순두부찌개.getId(),
                부대찌개.getId(), 라면.getId(), 라멘.getId(), 우동.getId(), 나가사키짬뽕.getId(), 짬뽕.getId(), 마라탕.getId(), 쌀국수.getId()
        );
        List<Long> dishesIds5 = Arrays.asList(
                보쌈.getId(), 순대.getId(), 족발.getId(), 찜닭.getId(), 곱창.getId(), 치킨.getId(), 닭발.getId(), 닭갈비.getId(), 김치찌개.getId()
        );
        List<Long> dishesIds6 = Arrays.asList(
                비빔국수.getId(), 잔치국수.getId(), 칼국수.getId(), 밀면.getId(), 전.getId(), 수제비.getId(), 떡볶이_밀떡.getId(),
                라면.getId(), 쫄면.getId(), 튀김_분식.getId(), 돈가스.getId(), 오코노미야끼.getId(), 타코야끼.getId(), 고로케.getId(),
                야끼소바.getId(), 라멘.getId(), 우동.getId(), 나가사키짬뽕.getId(), 피자.getId(), 토스트.getId(), 핫도그.getId(),
                샌드위치.getId(), 햄버거.getId(), 파스타.getId(), 짜장면.getId(), 짬뽕.getId(), 탕수육.getId(), 깐풍기.getId(),
                유린기.getId(), 꿔바로우.getId(), 군만두.getId(), 물만두.getId(), 딤섬.getId(), 깐풍새우.getId(), 깐쇼새우.getId(),
                타코.getId(), 부리또.getId()
        );
        List<Long> dishesIds7 = Arrays.asList(
                곱창.getId(), 치킨.getId(), 닭발.getId(), 라면.getId()
        );
        List<Long> dishesIds8 = Arrays.asList(
                육회.getId(), 회덮밥.getId(), 물회.getId(), 초밥.getId(), 사시미.getId()
        );
        List<Long> dishesIds9 = Arrays.asList(
                포케.getId(), 샐러드.getId()
        );
        List<Long> dishesIds10 = Arrays.asList(
                죽.getId(), 삼계탕.getId()
        );
        List<Long> dishesIds11 = Arrays.asList(
                물냉면.getId(), 비빔냉면.getId(), 밀면.getId(), 냉소바.getId()
        );
        List<Long> dishesIds12 = Arrays.asList(
                떡볶이_쌀떡.getId(), 떡볶이_밀떡.getId(), 라면.getId(), 쫄면.getId(), 튀김_분식.getId()
        );
        List<Long> dishesIds13 = Arrays.asList(
                김치찌개.getId(), 된장찌개.getId(), 순두부찌개.getId(), 부대찌개.getId(), 고추장찌개.getId(), 차돌박이김치찌개.getId()
        );
        List<Long> dishesIds14 = Arrays.asList(
                찜닭.getId(), 생선찜.getId(), 돼지갈비찜.getId(), 등갈비김치찜.getId()
        );
        List<Long> dishesIds15 = Arrays.asList(
                찜닭.getId(), 닭갈비.getId(), 닭발.getId(), 닭도리탕.getId(), 삼계탕.getId(), 깐풍기.getId(), 유린기.getId()
        );
        List<Long> dishesIds16 = Arrays.asList(
                떡갈비.getId(), 소갈비.getId(), 삼겹살.getId(), 보쌈.getId(), 족발.getId(), 곱창.getId(), 치킨.getId(), 만두.getId(),
                전.getId(), 삼계탕.getId(), 튀김_분식.getId(), 돈부리.getId(), 돈가스.getId(), 라멘.getId(), 피자.getId(),
                감바스.getId(), 짜장면.getId(), 짬뽕.getId(), 볶음밥_중식.getId(), 짜장밥.getId(), 짬뽕밥.getId(), 마파두부.getId(),
                탕수육.getId(), 깐풍기.getId(), 유린기.getId(), 꿔바로우.getId(), 군만두.getId(), 깐풍새우.getId(), 깐쇼새우.getId()
        );
        List<Long> dishesIds17 = Arrays.asList(
                김밥.getId(), 비빔밥.getId(), 볶음밥_한식.getId(), 덮밥.getId(), 컵밥.getId(), 죽.getId(), 메밀국수.getId(),
                비빔국수.getId(), 잔치국수.getId(), 칼국수.getId(), 물냉면.getId(), 비빔냉면.getId(), 밀면.getId(),
                떡볶이_쌀떡.getId(), 떡볶이_밀떡.getId(), 라면.getId(), 쫄면.getId(), 초밥.getId(), 고로케.getId(),
                우동.getId(), 냉소바.getId(), 토스트.getId(), 핫도그.getId(), 샌드위치.getId(), 부리또.getId(),
                포케.getId(), 샐러드.getId()
        );
        List<Long> dishesIds18 = Arrays.asList(
                쌀국수.getId(), 볶음쌀국수.getId(), 인도식카레.getId(), 타코.getId(), 부리또.getId(), 포케.getId()
        );
        List<Long> dishesIds19 = Arrays.asList(
                닭발.getId(), 짬뽕.getId(), 짬뽕밥.getId(), 마라샹궈.getId(), 마라탕.getId(), 훠궈.getId()
        );
        List<Long> dishesIds20 = Arrays.asList(
                메밀국수.getId(), 비빔국수.getId(), 잔치국수.getId(), 칼국수.getId(), 물냉면.getId(), 비빔냉면.getId(), 밀면.getId(),
                라면.getId(), 쫄면.getId(), 야끼소바.getId(), 라멘.getId(), 우동.getId(), 냉소바.getId(), 나가사키짬뽕.getId(),
                파스타.getId(), 짜장면.getId(), 짬뽕.getId(), 쌀국수.getId(), 볶음쌀국수.getId()
        );
        List<Long> dishesIds21 = Arrays.asList(
                튀김_분식.getId(), 고로케.getId(), 돈가스.getId(), 탕수육.getId(), 깐풍기.getId(), 유린기.getId(), 꿔바로우.getId()
        );
        List<Long> dishesIds22 = Arrays.asList(
                국밥.getId(), 떡국.getId(), 수제비.getId(), 갈비탕.getId(), 삼계탕.getId(), 샤브샤브.getId(), 쌀국수.getId()
        );
        List<Long> dishesIds23 = Arrays.asList(
                떡볶이_쌀떡.getId(), 떡볶이_밀떡.getId(), 토스트.getId(), 핫도그.getId(), 샌드위치.getId()
        );
        List<Long> dishesIds24 = Arrays.asList(
                떡갈비.getId(), 불고기.getId(), 소갈비.getId(), 삼겹살.getId(), 보쌈.getId(), 족발.getId(), 곱창.getId(), 치킨.getId(),
                닭발.getId(), 게장.getId(), 생선찜.getId(), 생선구이.getId(), 조개구이.getId(), 감자탕.getId(), 삼계탕.getId(), 스테이크.getId(),
                바비큐.getId(), 파스타.getId(), 깐풍새우.getId(), 깐쇼새우.getId()
        );
        List<Long> dishesIds25 = Arrays.asList(
                백반.getId(), 김밥.getId(), 비빔밥.getId(), 컵밥.getId(), 메밀국수.getId(), 비빔국수.getId(), 잔치국수.getId(),
                물냉면.getId(), 비빔냉면.getId(), 만두.getId(), 국밥.getId(), 떡볶이_쌀떡.getId(), 떡볶이_밀떡.getId(), 라면.getId(),
                쫄면.getId(), 튀김_분식.getId(), 토스트.getId(), 핫도그.getId(), 샌드위치.getId(), 햄버거.getId(), 짜장면.getId(),
                짬뽕.getId(), 볶음밥_중식.getId(), 짜장밥.getId(), 짬뽕밥.getId(), 군만두.getId(), 물만두.getId(), 부리또.getId(),
                샐러드.getId()
        );
        List<Long> dishesIds26 = Arrays.asList(
                비빔밥.getId(), 볶음밥_한식.getId(), 죽.getId(), 비빔국수.getId(), 김치찌개.getId(), 된장찌개.getId(), 순두부찌개.getId(),
                떡볶이_쌀떡.getId(), 떡볶이_밀떡.getId(), 라면.getId(), 토스트.getId(), 샌드위치.getId()
        );
        List<Long> dishesIds27 = Arrays.asList(
                백반.getId(), 떡갈비.getId(), 불고기.getId(), 소갈비.getId(), 보쌈.getId(), 게장.getId(), 생선찜.getId(),
                생선구이.getId(), 국밥.getId(), 갈비탕.getId(), 감자탕.getId(), 매운탕.getId(), 삼계탕.getId(), 김치찌개.getId(),
                된장찌개.getId(), 순두부찌개.getId()
        );
        List<Long> dishesIds28 = Arrays.asList(
                백반.getId(), 김밥.getId(), 비빔밥.getId(), 볶음밥_한식.getId(), 덮밥.getId(), 컵밥.getId(), 죽.getId(),
                메밀국수.getId(), 비빔국수.getId(), 잔치국수.getId(), 칼국수.getId(), 물냉면.getId(), 비빔냉면.getId(), 밀면.getId(),
                순대.getId(), 치킨.getId(), 만두.getId(), 생선구이.getId(), 회덮밥.getId(), 전.getId(), 국밥.getId(), 떡국.getId(),
                수제비.getId(), 갈비탕.getId(), 김치찌개.getId(), 된장찌개.getId(), 순두부찌개.getId(), 떡볶이_쌀떡.getId(), 떡볶이_밀떡.getId(),
                라면.getId(), 튀김_분식.getId(), 초밥.getId(), 돈부리.getId(), 돈가스.getId(), 오코노미야끼.getId(), 타코야끼.getId(),
                고로케.getId(), 야끼소바.getId(), 라멘.getId(), 우동.getId(), 냉소바.getId(), 짜장면.getId(), 짬뽕.getId(), 볶음밥_중식.getId(),
                짜장밥.getId(), 짬뽕밥.getId(), 잡채밥.getId(), 군만두.getId(), 물만두.getId(), 딤섬.getId(), 마라샹궈.getId(), 마라탕.getId(),
                쌀국수.getId(), 볶음쌀국수.getId(), 인도식카레.getId(), 타코.getId(), 부리또.getId(), 포케.getId(), 샐러드.getId()
        );
        List<Long> dishesIds29 = Arrays.asList(
                잔치국수.getId(), 칼국수.getId(),  전.getId(), 국밥.getId(), 수제비.getId(), 김치찌개.getId(),
                된장찌개.getId(), 순두부찌개.getId(), 부대찌개.getId(), 라면.getId(), 샤브샤브.getId(), 라멘.getId(), 우동.getId(),
                나가사키짬뽕.getId(), 쌀국수.getId()
        );
        List<Long> dishesIds30 = Arrays.asList(
                떡갈비.getId(), 소갈비.getId(), 생선찜.getId(), 조개구이.getId(), 사시미.getId(), 감바스.getId(), 파스타.getId(),
                리조또.getId(), 양꼬치.getId(), 스테이크.getId()
        );
        List<Long> dishesIds31 = Arrays.asList(
                삼겹살.getId(), 보쌈.getId(), 족발.getId(), 닭갈비.getId(), 곱창.getId(), 닭발.getId(), 전.getId(),
                감자탕.getId(), 갈비탕.getId(), 닭도리탕.getId(), 매운탕.getId(), 김치찌개.getId(), 부대찌개.getId(), 순두부찌개.getId(),
                샤브샤브.getId(), 물회.getId(),바비큐.getId(), 짜장면.getId(), 볶음밥_중식.getId(), 짜장밥.getId(), 짬뽕밥.getId(),
                잡채밥.getId(), 마파두부.getId(), 탕수육.getId(), 깐풍기.getId(), 딤섬.getId(), 깐풍새우.getId(), 깐쇼새우.getId(),
                마라탕.getId(), 훠궈.getId(), 마라샹궈.getId(), 딤섬.getId()
        );
        List<Long> dishesIds32 = Arrays.asList(
                백반.getId(), 잔치국수.getId(), 칼국수.getId(), 떡갈비.getId(), 불고기.getId(), 소갈비.getId(), 삼겹살.getId(),
                제육볶음.getId(), 보쌈.getId(), 족발.getId(), 닭갈비.getId(), 곱창.getId(), 치킨.getId(), 국밥.getId(),
                떡국.getId(), 갈비탕.getId(), 감자탕.getId(), 닭도리탕.getId(), 매운탕.getId(), 삼계탕.getId(), 김치찌개.getId(),
                순두부찌개.getId(), 부대찌개.getId(), 덮밥.getId(), 돈가스.getId(), 회덮밥.getId(), 나가사키짬뽕.getId(),
                짬뽕밥.getId(), 마파두부.getId(), 마라탕.getId(), 마라샹궈.getId()
        );
        List<Long> dishesIds33 = Arrays.asList(
                쫄면.getId(), 물냉면.getId(), 비빔냉면.getId(), 물회.getId(), 샐러드.getId()
        );
        List<Long> dishesIds34 = Arrays.asList(
                마라탕.getId(), 마라샹궈.getId(), 인도식카레.getId(), 훠궈.getId()
        );
        List<Long> dishesIds35 = Arrays.asList(
                김밥.getId(), 볶음밥_한식.getId(), 덮밥.getId(), 컵밥.getId(), 국밥.getId(), 치킨.getId(), 삼계탕.getId(),
                된장찌개.getId(), 김치찌개.getId(), 라면.getId(), 튀김_분식.getId(), 부대찌개.getId(), 우동.getId(),
                냉소바.getId(), 리조또.getId(), 파스타.getId(), 피자.getId(), 토스트.getId(), 핫도그 .getId(), 햄버거.getId(),
                샌드위치.getId(), 우동.getId(), 탕수육.getId()
        );
        List<Long> dishesIds36 = Arrays.asList(
                삼겹살.getId(), 생선찜.getId(), 생선구이.getId(), 조개구이.getId(), 감자탕.getId(), 닭도리탕.getId(),
                매운탕.getId(), 삼계탕.getId(), 불고기.getId(), 떡갈비.getId(), 곱창.getId(), 게장.getId(), 샤브샤브.getId(),
                물회.getId(), 회덮밥.getId()
        );
        List<Long> dishesIds37 = Arrays.asList(
                샤브샤브.getId(), 초밥.getId(), 돈부리.getId(), 돈가스.getId(), 회덮밥.getId(), 물회.getId(), 사시미.getId(),
                야끼소바.getId(),  오코노미야끼.getId(), 타코야끼.getId(), 고로케.getId(), 라멘.getId(), 우동.getId(),
                냉소바.getId(), 나가사키짬뽕.getId()
        );
        List<Long> dishesIds38 = Arrays.asList(
                짜장면.getId(), 짬뽕.getId(), 볶음밥_중식.getId(), 짜장밥.getId(), 짬뽕밥.getId(), 잡채밥.getId(),
                마파두부.getId(), 탕수육.getId(), 깐풍기.getId(), 유린기.getId(), 군만두.getId(), 물만두.getId(), 깐풍새우.getId(),
                깐쇼새우.getId(), 마라탕.getId(), 마라샹궈.getId(), 꿔바로우.getId()
        );
        List<Long> dishesIds39 = Arrays.asList(
                떡볶이_쌀떡.getId(), 떡볶이_밀떡.getId(), 닭발.getId(), 라면.getId(), 곱창.getId(), 매운탕.getId()
        );
        List<Long> dishesIds40 = Arrays.asList(
                김밥.getId(), 컵밥.getId(), 치킨.getId(), 국밥.getId(), 떡볶이_쌀떡.getId(), 떡볶이_밀떡.getId(), 라면.getId(),
                쫄면.getId(), 튀김_분식.getId(), 우동.getId(), 햄버거.getId()
        );
        List<Long> dishesIds41 = Arrays.asList(
                국밥.getId(), 갈비탕.getId(), 감자탕.getId(), 매운탕.getId(), 삼계탕.getId(), 김치찌개.getId(), 된장찌개.getId(),
                순두부찌개.getId(), 부대찌개.getId(), 돼지갈비찜.getId(), 등갈비김치찜.getId(), 고추장찌개.getId(),
                차돌박이김치찌개.getId()
        );
        List<Long> dishesIds42 = Arrays.asList(
                물냉면.getId(), 비빔냉면.getId(), 밀면.getId(), 냉소바.getId()
        );
        List<Long> dishesIds43 = Arrays.asList(
                비빔밥.getId(), 비빔냉면.getId(), 제육볶음.getId(), 닭갈비.getId(), 닭발.getId(), 육회.getId(), 감자탕.getId(),
                닭도리탕.getId(), 매운탕.getId(), 김치찌개.getId(), 순두부찌개.getId(), 부대찌개.getId(), 떡볶이_밀떡.getId(),
                떡볶이_쌀떡.getId(), 라면.getId(), 쫄면.getId(), 짬뽕.getId(), 깐풍새우.getId(), 깐쇼새우.getId(),
                마라샹궈.getId(), 마라탕.getId(), 훠궈.getId(), 볶음쌀국수.getId(), 등갈비김치찜.getId(), 고추장찌개.getId(),
                차돌박이김치찌개.getId()
        );
        List<Long> dishesIds44 = Arrays.asList(
                김밥.getId(), 비빔밥.getId(), 볶음밥_한식.getId(), 죽.getId(), 메밀국수.getId(), 비빔국수.getId(),
                잔치국수.getId(), 칼국수.getId(), 물냉면.getId(), 비빔냉면.getId(), 밀면.getId(), 전.getId(), 떡국.getId(),
                수제비.getId(), 김치찌개.getId(), 된장찌개.getId(), 순두부찌개.getId(), 부대찌개.getId(), 떡볶이_밀떡.getId(),
                떡볶이_쌀떡.getId(), 쫄면.getId(), 파스타.getId(), 마파두부.getId(), 포케.getId(), 샐러드.getId()
        );
        List<Long> dishesIds45 = Arrays.asList(
                백반.getId(), 김밥.getId(), 덮밥.getId(), 컵밥.getId(), 죽.getId(), 메밀국수.getId(), 떡갈비.getId(),
                삼겹살.getId(), 육회.getId(), 만두.getId(), 회덮밥.getId(), 전.getId(), 초밥.getId(), 돈가스.getId(),
                사시미.getId(), 타코야끼.getId(), 고로케.getId(), 토스트.getId(), 샌드위치.getId(), 햄버거.getId(), 군만두.getId(),
                물만두.getId(), 딤섬.getId(), 타코.getId(), 부리또.getId(), 포케.getId(), 샐러드.getId()
        );

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
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문11.getId(), dishesIds11));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문12.getId(), dishesIds12));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문13.getId(), dishesIds13));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문14.getId(), dishesIds14));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문15.getId(), dishesIds15));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문16.getId(), dishesIds16));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문17.getId(), dishesIds17));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문18.getId(), dishesIds18));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문19.getId(), dishesIds19));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문20.getId(), dishesIds20));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문21.getId(), dishesIds21));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문22.getId(), dishesIds22));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문23.getId(), dishesIds23));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문24.getId(), dishesIds24));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문25.getId(), dishesIds25));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문26.getId(), dishesIds26));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문27.getId(), dishesIds27));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문28.getId(), dishesIds28));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문29.getId(), dishesIds29));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문30.getId(), dishesIds30));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문31.getId(), dishesIds31));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문32.getId(), dishesIds32));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문33.getId(), dishesIds33));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문34.getId(), dishesIds34));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문35.getId(), dishesIds35));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문36.getId(), dishesIds36));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문37.getId(), dishesIds37));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문38.getId(), dishesIds38));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문39.getId(), dishesIds39));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문40.getId(), dishesIds40));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문41.getId(), dishesIds41));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문42.getId(), dishesIds42));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문43.getId(), dishesIds43));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문44.getId(), dishesIds44));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문45.getId(), dishesIds45));
    }

    private String createFilePath(String name) {
        return String.format(cloudfrontImageUrlFormat, name) + ".jpg";
    }
}
