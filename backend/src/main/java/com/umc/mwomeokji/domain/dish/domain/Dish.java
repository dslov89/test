package com.umc.mwomeokji.domain.dish.domain;

import com.umc.mwomeokji.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Dish extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String imageUrl;

    private String videoUrl1;

    private String videoUrl2;

    private String videoUrl3;

    @Builder
    public Dish(String name, String imageUrl, String videoUrl1, String videoUrl2, String videoUrl3) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.videoUrl1 = videoUrl1;
        this.videoUrl2 = videoUrl2;
        this.videoUrl3 = videoUrl3;
    }
}
