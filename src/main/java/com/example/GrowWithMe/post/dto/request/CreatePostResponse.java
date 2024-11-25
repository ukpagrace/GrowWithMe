package com.example.GrowWithMe.post.dto.request;

import com.example.GrowWithMe.comment.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Builder
public class CreatePostResponse {

    private Long id;
    private String content;
    private Long goalId;
    private List<Comment> comments;
}
