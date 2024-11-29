package com.example.GrowWithMe.post;


import com.example.GrowWithMe.ResourceNotFoundException;
import com.example.GrowWithMe.goal.model.Goal;
import com.example.GrowWithMe.goal.repository.GoalRepository;
import com.example.GrowWithMe.post.dto.request.CreatePostRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    private GoalRepository goalRepository;

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;


    private void assertThrowsGoalNotFoundException(Long id, Runnable serviceMethod) {
        when(goalRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(
                ResourceNotFoundException.class,
                serviceMethod::run,
                "goal not found"
        );
    }

    @Test
    public void PostService_CreatePost_throwsErrorIfGoalNotFound() {
        CreatePostRequest postRequest = CreatePostRequest
                .builder()
                .content("just finished modelling the kitchen")
                .goalId(1L)
                .build();

        assertThrowsGoalNotFoundException(postRequest.getGoalId(), () -> postService.createPost(postRequest));
    }

    @Test
    public void PostService_CreatePost() {
        Goal goal = new Goal();
        goal.setId(1L);
        goal.setTitle("Code hundred hours");

        CreatePostRequest postRequest = CreatePostRequest
                .builder()
                .content("just finished modelling the kitchen")
                .goalId(1L)
                .build();

        Post post = new Post();
        post.setId(2L);
        post.setContent(postRequest.getContent());
        post.setGoal(goal);


        when(goalRepository.findById(postRequest.getGoalId())).thenReturn(Optional.of(goal));
        when(postRepository.save(any(Post.class))).thenReturn(post);

        postService.createPost(postRequest);

        verify(postRepository, times(1)).save(Mockito.any(Post.class));
    }

    @Test
    public void PostService_GetPostWithGoalId_ThrowErrorGoalIdNotFound() {
        Long goalId = 1L;
        assertThrowsGoalNotFoundException(goalId, () -> postService.getPostsForGoal(goalId));
    }

    @Test
    public void PostService_GetPostWithGoalId_ReturnGoal() {
        Long goalId = 3L;
        Goal goal = new Goal();
        goal.setId(3L);
        goal.setTitle("Code hundred hours");
        ArrayList<Post> mockPosts = new ArrayList<>();
        Post post1 = new Post();
        post1.setId(1L);
        post1.setContent("Coded today");
        post1.setGoal(goal);

        Post post2 = new Post();
        post2.setId(1L);
        post2.setContent("built a pong games");
        post2.setGoal(goal);

        mockPosts.add(post1);
        mockPosts.add(post2);


        when(goalRepository.findById(goalId)).thenReturn(Optional.of(goal));
        when(postRepository.FindAllByGoalId(goalId)).thenReturn(mockPosts);
        List<Post> posts = postService.getPostsForGoal(goalId);
        Assertions.assertNotNull(posts);
        Assertions.assertEquals(2, posts.size());
        verify(postRepository, times(1)).FindAllByGoalId(goalId);
        verify(goalRepository, times(1)).findById(goalId);
    }

}
