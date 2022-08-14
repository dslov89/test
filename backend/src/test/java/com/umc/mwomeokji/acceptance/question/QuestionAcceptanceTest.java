package com.umc.mwomeokji.acceptance.question;

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
public class QuestionAcceptanceTest extends AcceptanceTest {

    @Autowired
    private QuestionAcceptanceTestTool questionAcceptanceTestTool;

    @DisplayName("모든 질문 조회")
    @Test
        void get_all_questions(){
        // given
        questionAcceptanceTestTool.saveQuestions();
        // when ,then

        RestAssured
                .given()
                    .log().all()    //http 요청을 로그로 띄워주기 위함
                .when()
                    .get("/questions")  //uri 로 http 요청
                .then()
                    .log().all()    //http 요청을 로그로 띄워주기 위함
                .assertThat().statusCode(HttpStatus.OK.value())     //http status 상태 확인
                .assertThat().contentType(ContentType.JSON)         //json 타입인지 확인
                .assertThat().body("question", Matchers.contains("시원한 음식은 어떠신가요?",
                                                                      "면 종류를 드시겠습니까?",
                                                                      "육류는 어떠신가요?",
                                                                      "해산물은 좋아하시나요?"));  //json 내용 확인
    }


}
