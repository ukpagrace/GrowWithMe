package com.example.GrowWithMe.post;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/post")
public class PostController {


    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    public void CreatePost(@RequestBody PostRequest postRequest){
        postService.createPost(postRequest);
    }

    @GetMapping("{id}")
    public List<Post> getPostsForAGoal(@PathVariable Long goalId){
        return postService.getPostsForGoal(goalId);
    }


    @PutMapping("{id}")
    public void EditPost(@PathVariable Long id, @RequestBody Post post){
        postService.editPost(id, post);
    }

    @DeleteMapping("{id}")
    public void DeletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
}
