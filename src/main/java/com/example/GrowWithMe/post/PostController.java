package com.example.GrowWithMe.post;


import com.example.GrowWithMe.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1/post")
public class PostController {
    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping()
    public void createPost(@Valid @RequestBody PostRequest postRequest){
        try{
            postService.createPost(postRequest);
        }catch (ResourceNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }

    }

    @GetMapping("{goalId}")
    public List<Post> getPostsForAGoal(@PathVariable Long goalId){
        return postService.getPostsForGoal(goalId);
    }


    @PutMapping("{id}")
    public void editPost(@PathVariable Long id, @RequestBody Post post){
        postService.editPost(id, post);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
}
