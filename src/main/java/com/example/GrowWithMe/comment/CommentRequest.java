package com.example.GrowWithMe.comment;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentRequest {

    private String comment;
    private Long parentId;
    private Long postId;

}
