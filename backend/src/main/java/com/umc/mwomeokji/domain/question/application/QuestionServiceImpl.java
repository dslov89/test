package com.umc.mwomeokji.domain.question.application;

import com.umc.mwomeokji.domain.dish.exception.NotFoundDishException;
import com.umc.mwomeokji.domain.question.dao.QuestionRepository;
import com.umc.mwomeokji.domain.question.domain.Question;
import com.umc.mwomeokji.domain.question.dto.QuestionDto.QuestionAndDishesResponse;
import com.umc.mwomeokji.domain.question.dto.QuestionDto.QuestionsNameResponse;
import com.umc.mwomeokji.domain.question.dto.QuestionMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    @Override
    @Transactional(readOnly = true)
    public List<QuestionsNameResponse> getAllQuestionsName(){
        List<Question> questionList = questionRepository.findAll();
        return questionList.stream().map(question -> questionMapper.toQuestionNameResponse(question)).collect(Collectors.toList());
    }
}
