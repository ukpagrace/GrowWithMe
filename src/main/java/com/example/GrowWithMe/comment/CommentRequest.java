package com.example.GrowWithMe.comment;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {

    private String comment;
    private Long parentId;
    private Long postId;

}
