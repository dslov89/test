package com.umc.mwomeokji.global.util.csv;

import com.umc.mwomeokji.domain.question.dto.QuestionDto.QuestionPostRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionCsvReader extends CsvReader{

    public QuestionCsvReader(MultipartFile file) {
        super(file);
    }

    public List<QuestionPostRequest> getQuestionPostRequests(List<String[]> questions) {
        return questions.stream()
                .map(line -> new QuestionPostRequest(line[0].trim()))
                .collect(Collectors.toList());
    }
}
