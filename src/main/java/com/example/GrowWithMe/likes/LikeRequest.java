package com.example.GrowWithMe.likes;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LikeRequest {

    @NotNull(message = "user id cannot be null")
    private Long user_id;
    @NotNull(message = "post id cannot be null")
    private Long post_id;
}
