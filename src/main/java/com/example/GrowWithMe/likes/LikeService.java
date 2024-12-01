package com.example.GrowWithMe.likes;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    LikeRepository likeRepository;
    ObjectMapper objectMapper;

    public LikeService(
            LikeRepository likeRepository,
            ObjectMapper objectMapper
    ){
       this.likeRepository = likeRepository;
       this.objectMapper = objectMapper;
    }
    public void likePost(LikeRequest likeRequest){

        Like like  = objectMapper.convertValue(likeRequest, Like.class);

        likeRepository.save(like);
    }

    public void unlikePost(LikeRequest likeRequest){
        Like like  = likeRepository.findPostIdAndUserId(likeRequest.getPost_id(), likeRequest.getUser_id());
        like.setIs_deleted(true);
    }
}
