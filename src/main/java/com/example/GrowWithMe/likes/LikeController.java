package com.example.GrowWithMe.likes;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/likes")
public class LikeController {
    LikeService likeService;

    public LikeController(
            LikeService likeService
    ) {
        this.likeService  = likeService;
    }

    @PostMapping()
    public void LikePost(LikeRequest likeRequest){
        likeService.likePost(likeRequest);
    }

    @DeleteMapping()
    public void unLinkPost(LikeRequest likeRequest){
        likeService.unlikePost(likeRequest);
    }


}
