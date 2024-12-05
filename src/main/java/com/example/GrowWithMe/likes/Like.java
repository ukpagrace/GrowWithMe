package com.example.GrowWithMe.likes;


import com.example.GrowWithMe.post.Post;
import com.example.GrowWithMe.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Like {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String entityType;

//    @ManyToOne
//    private Object entity;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean is_deleted;

    void solution() {
        user.getClass().getSimpleName();
    }
}
