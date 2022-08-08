package com.umc.mwomeokji.domain.questiondish.domain;

import com.umc.mwomeokji.domain.dish.domain.Dish;
import com.umc.mwomeokji.domain.question.domain.Question;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class QuestionDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Builder
    public QuestionDish(Question question, Dish dish) {
        this.question = question;
        this.dish = dish;
    }
}
