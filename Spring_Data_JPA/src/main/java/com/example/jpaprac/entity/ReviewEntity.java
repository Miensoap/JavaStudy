package com.example.jpaprac.entity;

import com.example.jpaprac.ReplyEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "REVIEW")
@Entity
public class ReviewEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "BOOKING_ID")
    private BookingEntity booking;

    private String content;

    @OneToOne @JoinColumn(name = "REPLY_ID")
    private ReplyEntity reply;

    public ReviewEntity(BookingEntity booking, String content) {
        this.booking = booking;
        this.content = content;
    }

    public void addReply(String content) {
        this.reply = new ReplyEntity(this , content);
    }

    public UserEntity getWriter(){
        return booking.getBooker();
    }
}
