package com.umc.mwomeokji.domain.question.domain;

import com.umc.mwomeokji.domain.dish.domain.Dish;
import com.umc.mwomeokji.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

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

    @Column(nullable = false)
    private String category;

    @OneToMany(mappedBy = "QuestionMapper", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)    //cascade, orphanRemoval 부모 자식관의 관계변환 따라가기
    private List<Dish> dishList = new ArrayList<>();

    @Builder
    public Question(String category) {
        this.category = category;
    }
    public void addDishes(Dish dish) {
        this.dishList.add(dish);
    }

}
