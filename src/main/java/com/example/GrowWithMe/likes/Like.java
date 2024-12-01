package com.example.GrowWithMe.likes;


import com.example.GrowWithMe.post.Post;
import com.example.GrowWithMe.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Like {

    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean is_deleted;
}
