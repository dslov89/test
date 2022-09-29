package com.umc.mwomeokji.domain.question.domain;

import com.umc.mwomeokji.domain.questiondish.domain.QuestionDish;
import com.umc.mwomeokji.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Question extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<QuestionDish> questionDishes = new ArrayList<>();

    @Builder
    public Question(String question) {
        this.question = question;
    }
}
