package com.example.GrowWithMe.post;


import com.example.GrowWithMe.comment.Comment;
import com.example.GrowWithMe.goal.model.Goal;
import com.example.GrowWithMe.likes.Like;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    @OneToMany
    private List<Like> likes;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;
}
