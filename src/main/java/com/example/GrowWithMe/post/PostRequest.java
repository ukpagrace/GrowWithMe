package com.example.GrowWithMe.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PostRequest {
    @NotBlank(message = "content cannot be empty")
    private String content;
    @NotNull(message = "Goal Id cannot be null")
    private Long goalId;
}
