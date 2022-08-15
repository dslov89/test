package com.umc.mwomeokji.domain.question.application;

import com.umc.mwomeokji.domain.question.dao.QuestionRepository;
import com.umc.mwomeokji.domain.question.domain.Question;
import com.umc.mwomeokji.domain.question.dto.QuestionDto;
import com.umc.mwomeokji.domain.question.dto.QuestionMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
public class QuestionServiceImplTest {

    @InjectMocks
    private QuestionServiceImpl questionService;

    @Mock
    private QuestionRepository questionRepository;

    @Spy
    @InjectMocks
    private QuestionMapper questionMapper = Mappers.getMapper(QuestionMapper.class);

    @DisplayName("모든 질문 조회")
    @Test
    void get_all_questions(){
        // given
        Question question1 = Question.builder().question("시원한 음식은 어떠신가요?").build();
        Question question2 = Question.builder().question("면 종류를 드시겠습니까?").build();
        List<Question> questionList = Stream.of(question1,question2).collect(Collectors.toList());
        given(questionRepository.findAll()).willReturn(questionList);

        // when
        QuestionDto.QuestionsNameResponse questionsNameResponseList = questionService.getAllQuestionsName();

        // then
        assertThat(questionsNameResponseList.getQuestion()).hasSize(2);
        assertThat(questionsNameResponseList.getQuestion()).containsExactly("시원한 음식은 어떠신가요?","면 종류를 드시겠습니까?");
        then(questionRepository).should(times(1)).findAll();
    }
}
