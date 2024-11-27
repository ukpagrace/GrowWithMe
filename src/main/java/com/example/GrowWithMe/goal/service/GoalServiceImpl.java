package com.example.GrowWithMe.goal.service;

import com.example.GrowWithMe.goal.repository.GoalRepository;
import com.example.GrowWithMe.goal.dto.request.CreateGoalRequest;
import com.example.GrowWithMe.goal.dto.response.CreateGoalResponse;
import com.example.GrowWithMe.goal.model.Goal;
import com.example.GrowWithMe.post.dto.request.CreatePostRequest;
import com.example.GrowWithMe.post.PostService;
import com.example.GrowWithMe.post.dto.response.CreatePostResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;
    private final PostService postService;
    private final ObjectMapper objectMapper;

    public GoalServiceImpl(GoalRepository goalRepository, PostService postService, ObjectMapper objectMapper){
        this.goalRepository = goalRepository;
        this.postService = postService;
        this.objectMapper = objectMapper;
    }

    public void add(Goal goal) {
        this.goalRepository.save(goal);
    }

    @Override
    public CreateGoalResponse createGoal(CreateGoalRequest request) {
        Goal goal = Goal.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .build();
        Goal savedGoal = this.goalRepository.save(goal);

        CreatePostRequest postRequest = objectMapper.convertValue(request, CreatePostRequest.class);
        postRequest.setGoalId(savedGoal.getId());
        CreatePostResponse newPost = this.postService.createPost(postRequest);

        return CreateGoalResponse.builder()
                .goalId(savedGoal.getId())
                .title(savedGoal.getTitle())
                .post(newPost)
                .build();
    }
}
