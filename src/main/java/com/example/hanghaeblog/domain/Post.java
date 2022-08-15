package com.example.hanghaeblog.domain;

import com.example.hanghaeblog.dto.PostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Post extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private LocalDateTime checkin;
    @Column(nullable = false)
    private LocalDateTime checkout;
    @Column(nullable = false)
    private int stars;

    public Post(PostDto postDto) {
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
        this.checkin = postDto.getCheckin();
        this.checkout = postDto.getCheckout();
        this.stars = postDto.getStars();
    }

    public void update(PostDto postDto) {
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
        this.checkin = postDto.getCheckin();
        this.checkout = postDto.getCheckout();
        this.stars = postDto.getStars();
    }

}
