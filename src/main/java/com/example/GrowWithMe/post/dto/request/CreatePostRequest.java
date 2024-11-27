package com.example.GrowWithMe.post.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class CreatePostRequest {
    @NotBlank(message = "content cannot be empty")
    private String content;
    @NotNull(message = "Goal Id cannot be null")
    private Long goalId;
}
