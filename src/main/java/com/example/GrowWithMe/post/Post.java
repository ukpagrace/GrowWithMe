package com.example.GrowWithMe.post;


import com.example.GrowWithMe.comment.Comment;
import com.example.GrowWithMe.goal.Goal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
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

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
