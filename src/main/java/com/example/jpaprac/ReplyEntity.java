package com.example.jpaprac;

import com.example.jpaprac.entity.BaseEntity;
import com.example.jpaprac.entity.ReviewEntity;
import com.example.jpaprac.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "REPLY")
@Entity
public class ReplyEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "reply")
    ReviewEntity review;

    String content;

    public ReplyEntity(ReviewEntity review, String content) {
        this.review = review;
        this.content = content;
    }

    public UserEntity getWriter(){
        return review.getBooking().getHost();
    }
}
