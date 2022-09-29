package com.umc.mwomeokji.domain.question.application;

import com.umc.mwomeokji.domain.question.dao.QuestionRepository;
import com.umc.mwomeokji.domain.question.domain.Question;
import com.umc.mwomeokji.domain.question.dto.QuestionDto.*;
import com.umc.mwomeokji.domain.question.dto.QuestionMapper;

import com.umc.mwomeokji.global.util.csv.QuestionCsvReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    @Override
    public void saveQuestion(QuestionPostRequest request) {
        questionRepository.save(questionMapper.toEntity(request));
    }

    @Override
    public void saveQuestionByCsv(MultipartFile file) {
        QuestionCsvReader questionCsvReader = new QuestionCsvReader(file);
        List<QuestionPostRequest> questionPostRequests = questionCsvReader.getQuestionPostRequests(questionCsvReader.readAll());
        List<Question> questions = questionPostRequests.stream()
                .map(request -> questionMapper.toEntity(request)).collect(Collectors.toList());
        questionRepository.saveAll(questions);
    }

    @Override
    @Transactional(readOnly = true)
    public QuestionsNameResponse getAllQuestionsName(){
        return questionMapper.toQuestionsNameResponse(questionRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuestionAndDishesResponse> getQuestionAndDishes() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionAndDishesResponse> questionAndDishesResponses = questions.stream().map(question ->
                        questionMapper.toQuestionAndDishesResponse(question, question.getQuestionDishes())).collect(Collectors.toList());
        return questionAndDishesResponses;
    }
}
