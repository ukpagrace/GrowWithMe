package com.example.GrowWithMe.goal.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class CreateGoalRequest {

    private String title;
    private String description;
    private String type;
    private Object createPostRequest;
}
