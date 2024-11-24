package com.example.GrowWithMe.post;


import com.example.GrowWithMe.ResourceNotFoundException;
import com.example.GrowWithMe.goal.model.Goal;
import com.example.GrowWithMe.goal.GoalRepository;
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

    public void createPost(PostRequest postRequest) {
        Goal goal = this.goalRepository.findById(postRequest.getGoalId())
                .orElseThrow(() -> new ResourceNotFoundException("Goal not found"));

        Post post  = new Post();
        post.setContent(postRequest.getContent());
        post.setGoal(goal);
        this.postRepository.save(post);
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
