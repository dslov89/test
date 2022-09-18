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
        Dish 볶음밥_한식 = Dish.builder().name("볶음밥(한식)").category(한식).imageUrl(createFilePath("볶음밥_한식")).build();
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
        Dish 볶음밥_중식 = Dish.builder().name("볶음밥(중식)").category(중식).imageUrl(createFilePath("볶음밥")).build();
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

        List<String> dishesNames1 = Arrays.asList(
                백반.getName(), 김밥.getName(), 비빔밥.getName(), 볶음밥_한식.getName(), 덮밥.getName(), 컵밥.getName(), 죽.getName(),
                메밀국수.getName(), 비빔국수.getName(), 잔치국수.getName(), 칼국수.getName(), 물냉면.getName(), 비빔냉면.getName(),
                밀면.getName(), 떡갈비.getName(), 불고기.getName(), 소갈비.getName(), 삼겹살.getName(), 제육볶음.getName(), 보쌈.getName(),
                순대.getName(), 족발.getName(), 찜닭.getName(), 닭갈비.getName(), 곱창.getName(), 치킨.getName(), 닭발.getName(),
                육회.getName(), 만두.getName(), 게장.getName(), 생선찜.getName(), 생선구이.getName(), 조개구이.getName(), 회덮밥.getName(),
                물회.getName(), 전.getName(), 국밥.getName(), 떡국.getName(), 수제비.getName(), 갈비탕.getName(), 감자탕.getName(),
                닭도리탕.getName(), 매운탕.getName(), 삼계탕.getName(), 김치찌개.getName(), 된장찌개.getName(), 순두부찌개.getName(),
                부대찌개.getName(), 떡볶이_쌀떡.getName(), 떡볶이_밀떡.getName(), 라면.getName(), 쫄면.getName(), 튀김_분식.getName()
        );
        List<String> dishesNames2 = Arrays.asList(
                떡갈비.getName(), 불고기.getName(), 소갈비.getName(), 삼겹살.getName(), 제육볶음.getName(), 보쌈.getName(), 순대.getName(),
                족발.getName(), 찜닭.getName(), 닭갈비.getName(), 곱창.getName(), 치킨.getName(), 닭발.getName(), 육회.getName(),
                스테이크.getName(), 바비큐.getName(), 탕수육.getName(), 깐풍기.getName(), 유린기.getName(), 꿔바로우.getName(), 군만두.getName(),
                물만두.getName(), 딤섬.getName(), 양꼬치.getName()
        );
        List<String> dishesNames3 = Arrays.asList(
                국밥.getName(), 칼국수.getName(), 떡국.getName(), 수제비.getName(), 갈비탕.getName(), 감자탕.getName(), 김치찌개.getName(),
                순두부찌개.getName(), 라면.getName(), 짬뽕.getName()
        );
        List<String> dishesNames4 = Arrays.asList(
                메밀국수.getName(), 잔치국수.getName(), 칼국수.getName(), 국밥.getName(), 떡국.getName(), 수제비.getName(), 갈비탕.getName(),
                감자탕.getName(), 닭도리탕.getName(), 매운탕.getName(), 삼계탕.getName(), 김치찌개.getName(), 된장찌개.getName(), 순두부찌개.getName(),
                부대찌개.getName(), 라면.getName(), 라멘.getName(), 우동.getName(), 나가사키짬뽕.getName(), 짬뽕.getName(), 마라탕.getName(), 쌀국수.getName()
        );
        List<String> dishesNames5 = Arrays.asList(
                보쌈.getName(), 순대.getName(), 족발.getName(), 찜닭.getName(), 곱창.getName(), 치킨.getName(), 닭발.getName(), 닭갈비.getName(), 김치찌개.getName()
        );
        List<String> dishesNames6 = Arrays.asList(
                비빔국수.getName(), 잔치국수.getName(), 칼국수.getName(), 밀면.getName(), 전.getName(), 수제비.getName(), 떡볶이_밀떡.getName(),
                라면.getName(), 쫄면.getName(), 튀김_분식.getName(), 돈가스.getName(), 오코노미야끼.getName(), 타코야끼.getName(), 고로케.getName(),
                야끼소바.getName(), 라멘.getName(), 우동.getName(), 나가사키짬뽕.getName(), 피자.getName(), 토스트.getName(), 핫도그.getName(),
                샌드위치.getName(), 햄버거.getName(), 파스타.getName(), 짜장면.getName(), 짬뽕.getName(), 탕수육.getName(), 깐풍기.getName(),
                유린기.getName(), 꿔바로우.getName(), 군만두.getName(), 물만두.getName(), 딤섬.getName(), 깐풍새우.getName(), 깐쇼새우.getName(),
                타코.getName(), 부리또.getName()
        );
        List<String> dishesNames7 = Arrays.asList(
                곱창.getName(), 치킨.getName(), 닭발.getName(), 라면.getName()
        );
        List<String> dishesNames8 = Arrays.asList(
                육회.getName(), 회덮밥.getName(), 물회.getName(), 초밥.getName(), 사시미.getName()
        );
        List<String> dishesNames9 = Arrays.asList(
                포케.getName(), 샐러드.getName()
        );
        List<String> dishesNames10 = Arrays.asList(
                죽.getName(), 삼계탕.getName()
        );
        List<String> dishesNames11 = Arrays.asList(
                물냉면.getName(), 비빔냉면.getName(), 밀면.getName(), 냉소바.getName()
        );
        List<String> dishesNames12 = Arrays.asList(
                떡볶이_쌀떡.getName(), 떡볶이_밀떡.getName(), 라면.getName(), 쫄면.getName(), 튀김_분식.getName()
        );
        List<String> dishesNames13 = Arrays.asList(
                김치찌개.getName(), 된장찌개.getName(), 순두부찌개.getName(), 부대찌개.getName(), 고추장찌개.getName(), 차돌박이김치찌개.getName()
        );
        List<String> dishesNames14 = Arrays.asList(
                찜닭.getName(), 생선찜.getName(), 돼지갈비찜.getName(), 등갈비김치찜.getName()
        );
        List<String> dishesNames15 = Arrays.asList(
                찜닭.getName(), 닭갈비.getName(), 닭발.getName(), 닭도리탕.getName(), 삼계탕.getName(), 깐풍기.getName(), 유린기.getName()
        );
        List<String> dishesNames16 = Arrays.asList(
                떡갈비.getName(), 소갈비.getName(), 삼겹살.getName(), 보쌈.getName(), 족발.getName(), 곱창.getName(), 치킨.getName(), 만두.getName(),
                전.getName(), 삼계탕.getName(), 튀김_분식.getName(), 돈부리.getName(), 돈가스.getName(), 라멘.getName(), 피자.getName(),
                감바스.getName(), 짜장면.getName(), 짬뽕.getName(), 볶음밥_중식.getName(), 짜장밥.getName(), 짬뽕밥.getName(), 마파두부.getName(),
                탕수육.getName(), 깐풍기.getName(), 유린기.getName(), 꿔바로우.getName(), 군만두.getName(), 깐풍새우.getName(), 깐쇼새우.getName()
        );
        List<String> dishesNames17 = Arrays.asList(
                김밥.getName(), 비빔밥.getName(), 볶음밥_한식.getName(), 덮밥.getName(), 컵밥.getName(), 죽.getName(), 메밀국수.getName(),
                비빔국수.getName(), 잔치국수.getName(), 칼국수.getName(), 물냉면.getName(), 비빔냉면.getName(), 밀면.getName(),
                떡볶이_쌀떡.getName(), 떡볶이_밀떡.getName(), 라면.getName(), 쫄면.getName(), 초밥.getName(), 고로케.getName(),
                우동.getName(), 냉소바.getName(), 토스트.getName(), 핫도그.getName(), 샌드위치.getName(), 부리또.getName(),
                포케.getName(), 샐러드.getName()
        );
        List<String> dishesNames18 = Arrays.asList(
                쌀국수.getName(), 볶음쌀국수.getName(), 인도식카레.getName(), 타코.getName(), 부리또.getName(), 포케.getName()
        );
        List<String> dishesNames19 = Arrays.asList(
                닭발.getName(), 짬뽕.getName(), 짬뽕밥.getName(), 마라샹궈.getName(), 마라탕.getName(), 훠궈.getName()
        );
        List<String> dishesNames20 = Arrays.asList(
                메밀국수.getName(), 비빔국수.getName(), 잔치국수.getName(), 칼국수.getName(), 물냉면.getName(), 비빔냉면.getName(), 밀면.getName(),
                라면.getName(), 쫄면.getName(), 야끼소바.getName(), 라멘.getName(), 우동.getName(), 냉소바.getName(), 나가사키짬뽕.getName(),
                파스타.getName(), 짜장면.getName(), 짬뽕.getName(), 쌀국수.getName(), 볶음쌀국수.getName()
        );
        List<String> dishesNames21 = Arrays.asList(
                튀김_분식.getName(), 고로케.getName(), 돈가스.getName(), 탕수육.getName(), 깐풍기.getName(), 유린기.getName(), 꿔바로우.getName()
        );
        List<String> dishesNames22 = Arrays.asList(
                국밥.getName(), 떡국.getName(), 수제비.getName(), 갈비탕.getName(), 삼계탕.getName(), 샤브샤브.getName(), 쌀국수.getName()
        );
        List<String> dishesNames23 = Arrays.asList(
                떡볶이_쌀떡.getName(), 떡볶이_밀떡.getName(), 토스트.getName(), 핫도그.getName(), 샌드위치.getName()
        );
        List<String> dishesNames24 = Arrays.asList(
                떡갈비.getName(), 불고기.getName(), 소갈비.getName(), 삼겹살.getName(), 보쌈.getName(), 족발.getName(), 곱창.getName(), 치킨.getName(),
                닭발.getName(), 게장.getName(), 생선찜.getName(), 생선구이.getName(), 조개구이.getName(), 감자탕.getName(), 삼계탕.getName(), 스테이크.getName(),
                바비큐.getName(), 파스타.getName(), 깐풍새우.getName(), 깐쇼새우.getName()
        );
        List<String> dishesNames25 = Arrays.asList(
                백반.getName(), 김밥.getName(), 비빔밥.getName(), 컵밥.getName(), 메밀국수.getName(), 비빔국수.getName(), 잔치국수.getName(),
                물냉면.getName(), 비빔냉면.getName(), 만두.getName(), 국밥.getName(), 떡볶이_쌀떡.getName(), 떡볶이_밀떡.getName(), 라면.getName(),
                쫄면.getName(), 튀김_분식.getName(), 토스트.getName(), 핫도그.getName(), 샌드위치.getName(), 햄버거.getName(), 짜장면.getName(),
                짬뽕.getName(), 볶음밥_중식.getName(), 짜장밥.getName(), 짬뽕밥.getName(), 군만두.getName(), 물만두.getName(), 부리또.getName(),
                샐러드.getName()
        );
        List<String> dishesNames26 = Arrays.asList(
                비빔밥.getName(), 볶음밥_한식.getName(), 죽.getName(), 비빔국수.getName(), 김치찌개.getName(), 된장찌개.getName(), 순두부찌개.getName(),
                떡볶이_쌀떡.getName(), 떡볶이_밀떡.getName(), 라면.getName(), 토스트.getName(), 샌드위치.getName()
        );
        List<String> dishesNames27 = Arrays.asList(
                백반.getName(), 떡갈비.getName(), 불고기.getName(), 소갈비.getName(), 보쌈.getName(), 게장.getName(), 생선찜.getName(),
                생선구이.getName(), 국밥.getName(), 갈비탕.getName(), 감자탕.getName(), 매운탕.getName(), 삼계탕.getName(), 김치찌개.getName(),
                된장찌개.getName(), 순두부찌개.getName()
        );
        List<String> dishesNames28 = Arrays.asList(
                백반.getName(), 김밥.getName(), 비빔밥.getName(), 볶음밥_한식.getName(), 덮밥.getName(), 컵밥.getName(), 죽.getName(),
                메밀국수.getName(), 비빔국수.getName(), 잔치국수.getName(), 칼국수.getName(), 물냉면.getName(), 비빔냉면.getName(), 밀면.getName(),
                순대.getName(), 치킨.getName(), 만두.getName(), 생선구이.getName(), 회덮밥.getName(), 전.getName(), 국밥.getName(), 떡국.getName(),
                수제비.getName(), 갈비탕.getName(), 김치찌개.getName(), 된장찌개.getName(), 순두부찌개.getName(), 떡볶이_쌀떡.getName(), 떡볶이_밀떡.getName(),
                라면.getName(), 튀김_분식.getName(), 초밥.getName(), 돈부리.getName(), 돈가스.getName(), 오코노미야끼.getName(), 타코야끼.getName(),
                고로케.getName(), 야끼소바.getName(), 라멘.getName(), 우동.getName(), 냉소바.getName(), 짜장면.getName(), 짬뽕.getName(), 볶음밥_중식.getName(),
                짜장밥.getName(), 짬뽕밥.getName(), 잡채밥.getName(), 군만두.getName(), 물만두.getName(), 딤섬.getName(), 마라샹궈.getName(), 마라탕.getName(),
                쌀국수.getName(), 볶음쌀국수.getName(), 인도식카레.getName(), 타코.getName(), 부리또.getName(), 포케.getName(), 샐러드.getName()
        );
        List<String> dishesNames29 = Arrays.asList(
                잔치국수.getName(), 칼국수.getName(),  전.getName(), 국밥.getName(), 수제비.getName(), 김치찌개.getName(),
                된장찌개.getName(), 순두부찌개.getName(), 부대찌개.getName(), 라면.getName(), 샤브샤브.getName(), 라멘.getName(), 우동.getName(),
                나가사키짬뽕.getName(), 쌀국수.getName()
        );
        List<String> dishesNames30 = Arrays.asList(
                떡갈비.getName(), 소갈비.getName(), 생선찜.getName(), 조개구이.getName(), 사시미.getName(), 감바스.getName(), 파스타.getName(),
                리조또.getName(), 양꼬치.getName(), 스테이크.getName()
        );
        List<String> dishesNames31 = Arrays.asList(
                삼겹살.getName(), 보쌈.getName(), 족발.getName(), 닭갈비.getName(), 곱창.getName(), 닭발.getName(), 전.getName(),
                감자탕.getName(), 갈비탕.getName(), 닭도리탕.getName(), 매운탕.getName(), 김치찌개.getName(), 부대찌개.getName(), 순두부찌개.getName(),
                샤브샤브.getName(), 물회.getName(),바비큐.getName(), 짜장면.getName(), 볶음밥_중식.getName(), 짜장밥.getName(), 짬뽕밥.getName(),
                잡채밥.getName(), 마파두부.getName(), 탕수육.getName(), 깐풍기.getName(), 딤섬.getName(), 깐풍새우.getName(), 깐쇼새우.getName(),
                마라탕.getName(), 훠궈.getName(), 마라샹궈.getName(), 딤섬.getName()
        );
        List<String> dishesNames32 = Arrays.asList(
                백반.getName(), 잔치국수.getName(), 칼국수.getName(), 떡갈비.getName(), 불고기.getName(), 소갈비.getName(), 삼겹살.getName(),
                제육볶음.getName(), 보쌈.getName(), 족발.getName(), 닭갈비.getName(), 곱창.getName(), 치킨.getName(), 국밥.getName(),
                떡국.getName(), 갈비탕.getName(), 감자탕.getName(), 닭도리탕.getName(), 매운탕.getName(), 삼계탕.getName(), 김치찌개.getName(),
                순두부찌개.getName(), 부대찌개.getName(), 덮밥.getName(), 돈가스.getName(), 회덮밥.getName(), 나가사키짬뽕.getName(),
                짬뽕밥.getName(), 마파두부.getName(), 마라탕.getName(), 마라샹궈.getName()
        );
        List<String> dishesNames33 = Arrays.asList(
                쫄면.getName(), 물냉면.getName(), 비빔냉면.getName(), 물회.getName(), 샐러드.getName()
        );
        List<String> dishesNames34 = Arrays.asList(
                마라탕.getName(), 마라샹궈.getName(), 인도식카레.getName(), 훠궈.getName()
        );
        List<String> dishesNames35 = Arrays.asList(
                김밥.getName(), 볶음밥_한식.getName(), 덮밥.getName(), 컵밥.getName(), 국밥.getName(), 치킨.getName(), 삼계탕.getName(),
                된장찌개.getName(), 김치찌개.getName(), 라면.getName(), 튀김_분식.getName(), 부대찌개.getName(), 우동.getName(),
                냉소바.getName(), 리조또.getName(), 파스타.getName(), 피자.getName(), 토스트.getName(), 핫도그 .getName(), 햄버거.getName(),
                샌드위치.getName(), 우동.getName(), 탕수육.getName()
        );
        List<String> dishesNames36 = Arrays.asList(
                삼겹살.getName(), 생선찜.getName(), 생선구이.getName(), 조개구이.getName(), 감자탕.getName(), 닭도리탕.getName(),
                매운탕.getName(), 삼계탕.getName(), 불고기.getName(), 떡갈비.getName(), 곱창.getName(), 게장.getName(), 샤브샤브.getName(),
                물회.getName(), 회덮밥.getName()
        );
        List<String> dishesNames37 = Arrays.asList(
                샤브샤브.getName(), 초밥.getName(), 돈부리.getName(), 돈가스.getName(), 회덮밥.getName(), 물회.getName(), 사시미.getName(),
                야끼소바.getName(),  오코노미야끼.getName(), 타코야끼.getName(), 고로케.getName(), 라멘.getName(), 우동.getName(),
                냉소바.getName(), 나가사키짬뽕.getName()
        );
        List<String> dishesNames38 = Arrays.asList(
                짜장면.getName(), 짬뽕.getName(), 볶음밥_중식.getName(), 짜장밥.getName(), 짬뽕밥.getName(), 잡채밥.getName(),
                마파두부.getName(), 탕수육.getName(), 깐풍기.getName(), 유린기.getName(), 군만두.getName(), 물만두.getName(), 깐풍새우.getName(),
                깐쇼새우.getName(), 마라탕.getName(), 마라샹궈.getName(), 꿔바로우.getName()
        );
        List<String> dishesNames39 = Arrays.asList(
                떡볶이_쌀떡.getName(), 떡볶이_밀떡.getName(), 닭발.getName(), 라면.getName(), 곱창.getName(), 매운탕.getName()
        );
        List<String> dishesNames40 = Arrays.asList(
                김밥.getName(), 컵밥.getName(), 치킨.getName(), 국밥.getName(), 떡볶이_쌀떡.getName(), 떡볶이_밀떡.getName(), 라면.getName(),
                쫄면.getName(), 튀김_분식.getName(), 우동.getName(), 햄버거.getName()
        );
        List<String> dishesNames41 = Arrays.asList(
                국밥.getName(), 갈비탕.getName(), 감자탕.getName(), 매운탕.getName(), 삼계탕.getName(), 김치찌개.getName(), 된장찌개.getName(),
                순두부찌개.getName(), 부대찌개.getName(), 돼지갈비찜.getName(), 등갈비김치찜.getName(), 고추장찌개.getName(),
                차돌박이김치찌개.getName()
        );
        List<String> dishesNames42 = Arrays.asList(
                물냉면.getName(), 비빔냉면.getName(), 밀면.getName(), 냉소바.getName()
        );
        List<String> dishesNames43 = Arrays.asList(
                비빔밥.getName(), 비빔냉면.getName(), 제육볶음.getName(), 닭갈비.getName(), 닭발.getName(), 육회.getName(), 감자탕.getName(),
                닭도리탕.getName(), 매운탕.getName(), 김치찌개.getName(), 순두부찌개.getName(), 부대찌개.getName(), 떡볶이_밀떡.getName(),
                떡볶이_쌀떡.getName(), 라면.getName(), 쫄면.getName(), 짬뽕.getName(), 깐풍새우.getName(), 깐쇼새우.getName(),
                마라샹궈.getName(), 마라탕.getName(), 훠궈.getName(), 볶음쌀국수.getName(), 등갈비김치찜.getName(), 고추장찌개.getName(),
                차돌박이김치찌개.getName()
        );
        List<String> dishesNames44 = Arrays.asList(
                김밥.getName(), 비빔밥.getName(), 볶음밥_한식.getName(), 죽.getName(), 메밀국수.getName(), 비빔국수.getName(),
                잔치국수.getName(), 칼국수.getName(), 물냉면.getName(), 비빔냉면.getName(), 밀면.getName(), 전.getName(), 떡국.getName(),
                수제비.getName(), 김치찌개.getName(), 된장찌개.getName(), 순두부찌개.getName(), 부대찌개.getName(), 떡볶이_밀떡.getName(),
                떡볶이_쌀떡.getName(), 쫄면.getName(), 파스타.getName(), 마파두부.getName(), 포케.getName(), 샐러드.getName()
        );
        List<String> dishesNames45 = Arrays.asList(
                백반.getName(), 김밥.getName(), 덮밥.getName(), 컵밥.getName(), 죽.getName(), 메밀국수.getName(), 떡갈비.getName(),
                삼겹살.getName(), 육회.getName(), 만두.getName(), 회덮밥.getName(), 전.getName(), 초밥.getName(), 돈가스.getName(),
                사시미.getName(), 타코야끼.getName(), 고로케.getName(), 토스트.getName(), 샌드위치.getName(), 햄버거.getName(), 군만두.getName(),
                물만두.getName(), 딤섬.getName(), 타코.getName(), 부리또.getName(), 포케.getName(), 샐러드.getName()
        );

        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문1.getId(), dishesNames1));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문2.getId(), dishesNames2));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문3.getId(), dishesNames3));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문4.getId(), dishesNames4));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문5.getId(), dishesNames5));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문6.getId(), dishesNames6));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문7.getId(), dishesNames7));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문8.getId(), dishesNames8));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문9.getId(), dishesNames9));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문10.getId(), dishesNames10));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문11.getId(), dishesNames11));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문12.getId(), dishesNames12));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문13.getId(), dishesNames13));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문14.getId(), dishesNames14));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문15.getId(), dishesNames15));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문16.getId(), dishesNames16));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문17.getId(), dishesNames17));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문18.getId(), dishesNames18));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문19.getId(), dishesNames19));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문20.getId(), dishesNames20));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문21.getId(), dishesNames21));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문22.getId(), dishesNames22));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문23.getId(), dishesNames23));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문24.getId(), dishesNames24));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문25.getId(), dishesNames25));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문26.getId(), dishesNames26));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문27.getId(), dishesNames27));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문28.getId(), dishesNames28));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문29.getId(), dishesNames29));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문30.getId(), dishesNames30));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문31.getId(), dishesNames31));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문32.getId(), dishesNames32));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문33.getId(), dishesNames33));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문34.getId(), dishesNames34));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문35.getId(), dishesNames35));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문36.getId(), dishesNames36));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문37.getId(), dishesNames37));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문38.getId(), dishesNames38));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문39.getId(), dishesNames39));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문40.getId(), dishesNames40));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문41.getId(), dishesNames41));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문42.getId(), dishesNames42));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문43.getId(), dishesNames43));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문44.getId(), dishesNames44));
        questionDishService.saveQuestionDishes(new QuestionDishDto.QuestionDishesPostRequest(질문45.getId(), dishesNames45));
    }

    private String createFilePath(String name) {
        return String.format(cloudfrontImageUrlFormat, name) + ".jpg";
    }
}
