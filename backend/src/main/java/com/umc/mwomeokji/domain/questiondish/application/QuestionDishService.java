package com.umc.mwomeokji.domain.questiondish.application;

import com.umc.mwomeokji.domain.questiondish.dto.QuestionDishDto.*;
import org.springframework.web.multipart.MultipartFile;

public interface QuestionDishService {

    void saveQuestionDishes(QuestionDishesPostRequest request);

    void saveQuestionDishesByCsv(MultipartFile file);
}
