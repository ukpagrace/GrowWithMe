package com.example.GrowWithMe.comment;

import com.example.GrowWithMe.likes.Like;
import com.example.GrowWithMe.post.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_seq_generator")
    @SequenceGenerator(name = "comments_seq_generator", sequenceName = "comments_seq", allocationSize = 1)
    private Long Id;

    private  String Content;

    @Column(nullable = true, name = "parent_id")
    private Long parentId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany
    private List<Like> likes;

}
