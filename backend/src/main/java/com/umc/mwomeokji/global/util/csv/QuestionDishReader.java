package com.umc.mwomeokji.global.util.csv;

import com.umc.mwomeokji.domain.questiondish.dto.QuestionDishDto.QuestionDishesPostRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionDishReader extends CsvReader {

    public QuestionDishReader(MultipartFile file) {
        super(file);
    }

    public List<QuestionDishesPostRequest> getQuestionDishesPostRequest(List<String[]> questionDishes) {
        return questionDishes.stream()
                .map(line -> new QuestionDishesPostRequest(Long.parseLong(line[0].trim()), splitToList(line[1].trim())))
                .collect(Collectors.toList());
    }

    private List<String> splitToList(String str) {
        List<String> dishNamesList = Arrays.asList(str.split(","));
        return dishNamesList.stream().map(name -> name.trim()).collect(Collectors.toList());
    }
}
