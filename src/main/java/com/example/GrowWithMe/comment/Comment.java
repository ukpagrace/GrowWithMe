package com.example.GrowWithMe.comment;

import com.example.GrowWithMe.post.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_seq_generator")
    @SequenceGenerator(name = "comments_seq_generator", sequenceName = "comments_seq", allocationSize = 1)
    public Long Id;

    public  String Content;

    @Column(nullable = true, name = "parent_id")
    public Long parentId;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;



}
