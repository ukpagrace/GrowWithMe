package com.example.GrowWithMe.goal.dto.response;

import com.example.GrowWithMe.post.dto.response.CreatePostResponse;
import lombok.*;

@Getter @Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class CreateGoalResponse {

    private Long goalId;
    private String title;
    private String description;
    private String type;
    private CreatePostResponse post;
}
