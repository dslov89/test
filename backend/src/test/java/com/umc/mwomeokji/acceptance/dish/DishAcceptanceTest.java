package com.umc.mwomeokji.acceptance.dish;

import com.umc.mwomeokji.acceptance.AcceptanceTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Disabled
public class DishAcceptanceTest extends AcceptanceTest {

    @Autowired
    private DishAcceptanceTestTool dishAcceptanceTestTool;

    @DisplayName("모든 메뉴 이름 조회")
    @Test
        void get_all_dishes_name() {
        // given
        dishAcceptanceTestTool.saveDishes();

        // when, then
        RestAssured
                .given()
                    .log().all() // http 요청을 로그로 띄워주기 위함
                .when()
                    .get("/dishes/name") // 해당 uri 로 http 요청
                .then()
                    .log().all() // http 응답을 로그로 띄워주기 위함
                    .assertThat().statusCode(HttpStatus.OK.value()) // http status 확인
                    .assertThat().contentType(ContentType.JSON) // json 형식인지 확인
                    .assertThat().body("name", Matchers.contains("마라탕", "궁보계정", "까르보나라", "오야코동", "곱창")); // json 내용 확인
    }

    @DisplayName("메뉴 상세 정보 조회")
    @Test
    void get_dish_details_success() {
        // given
        dishAcceptanceTestTool.saveDishes();

        // when, then
        RestAssured
                .given()
                    .log().all()
                .when()
                    .get("/dishes/1")
                .then()
                    .log().all()
                    .assertThat().statusCode(HttpStatus.OK.value()) // http status 확인
                    .assertThat().contentType(ContentType.JSON) // json 형식인지 확인
                    .assertThat().body("name", Matchers.equalTo("마라탕"))
                    .assertThat().body("imageUrl", Matchers.equalTo("마라탕 이미지"))
                    .assertThat().body("videoUrl1", Matchers.equalTo("마라탕 영상 1"))
                    .assertThat().body("videoUrl2", Matchers.equalTo("마라탕 영상 2"))
                    .assertThat().body("videoUrl3", Matchers.equalTo("마라탕 영상 3"));
    }
}
