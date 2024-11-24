package com.example.GrowWithMe.post;


import com.example.GrowWithMe.ResourceNotFoundException;
import com.example.GrowWithMe.goal.model.Goal;
import com.example.GrowWithMe.goal.repository.GoalRepository;
import com.example.GrowWithMe.post.dto.request.CreatePostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    PostRepository postRepository;
    GoalRepository goalRepository;

    @Autowired
    public PostService(
            PostRepository postRepository,
            GoalRepository goalRepository
    ) {
        this.postRepository = postRepository;
        this.goalRepository = goalRepository;
    }

    public CreatePostResponse createPost(PostRequest postRequest) {
        Goal goal = this.goalRepository.findById(postRequest.getGoalId())
                .orElseThrow(() -> new ResourceNotFoundException("Goal not found"));

        Post post  = new Post();
        post.setContent(postRequest.getContent());
        post.setGoal(goal);
        Post savedPost = this.postRepository.save(post);

        return CreatePostResponse.builder()
                .id(savedPost.getId())
                .content(savedPost.getContent())
                .comments(savedPost.getComments())
                .goalId(goal.getId())
                .build();
    }


    public void editPost(Long id, Post post) {
        Post foundPost  = this.postRepository.findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Post with Id" + id + "not found"));

        foundPost.setContent(post.getContent());
    }

    public void deletePost(Long id) {
        Post foundPost = this.postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with Id" + id + "not found"));

        foundPost.setIsDeleted(!foundPost.getIsDeleted());
    }

    public List<Post> getPostsForGoal(Long goalId) {
        Goal goal = this.goalRepository.findById(goalId)
                .orElseThrow(() ->  new ResourceNotFoundException("Goal not found"));

        return this.postRepository.FindAllByGoalId(goal.getId());
    }
}
