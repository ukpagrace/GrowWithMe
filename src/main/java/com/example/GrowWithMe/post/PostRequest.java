package com.example.GrowWithMe.post;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PostRequest {
    private String content;
    @NotNull(message = "Goal Id cannot be null")
    private Long goalId;
}
