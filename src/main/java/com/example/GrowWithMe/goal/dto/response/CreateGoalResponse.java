package com.example.GrowWithMe.goal.dto.response;

import com.example.GrowWithMe.post.Post;
import com.example.GrowWithMe.post.dto.request.CreatePostResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
@Builder
public class CreateGoalResponse {

    private Long goalId;
    private String title;
    private String description;
    private String type;
    private CreatePostResponse post;
}
