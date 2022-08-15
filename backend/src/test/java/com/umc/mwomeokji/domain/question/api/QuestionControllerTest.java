package com.umc.mwomeokji.domain.question.api;


import com.umc.mwomeokji.domain.question.application.QuestionService;
import com.umc.mwomeokji.domain.question.dto.QuestionDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuestionController.class)
public class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    @DisplayName("모든 질문 조회")
    @Test
    void get_all_questions() throws Exception{
        // given
        QuestionDto.QuestionsNameResponse questionsNameResponseList = new QuestionDto.QuestionsNameResponse(Arrays.asList("먹고싶은 음식은?", "자장면 먹고싶나요?"));
        given(questionService.getAllQuestionsName()).willReturn(questionsNameResponseList);
        // when, then

        mockMvc.perform(get("/questions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.question.[0]").value("먹고싶은 음식은?"))
                .andExpect(jsonPath("$.question.[1]").value("자장면 먹고싶나요?"))
                .andDo(print());
        verify(questionService, atMostOnce()).getAllQuestionsName();
    }


}
