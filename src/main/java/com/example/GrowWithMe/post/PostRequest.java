package com.example.GrowWithMe.post;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PostRequest {
    private String content;
    private Long goalId;
}
