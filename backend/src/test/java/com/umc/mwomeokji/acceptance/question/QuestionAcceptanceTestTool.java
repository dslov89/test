package com.umc.mwomeokji.acceptance.question;

import com.umc.mwomeokji.domain.question.dao.QuestionRepository;
import com.umc.mwomeokji.domain.question.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionAcceptanceTestTool {

    @Autowired
    private QuestionRepository questionRepository;

    public void saveQuestions(){
        questionRepository.save(createQuestion("시원한 음식은 어떠신가요?"));
        questionRepository.save(createQuestion("면 종류를 드시겠습니까?"));
        questionRepository.save(createQuestion("육류는 어떠신가요?"));
        questionRepository.save(createQuestion("해산물은 좋아하시나요?"));
    }
    /*
        1. 질문 id ,  조회
        2. 질문에 맞는 음식 리스트 반환
     */

    private Question createQuestion(String question){
        return Question.builder()
                .question(question).build();
    }
}
