package com.example.GrowWithMe.post;


import com.example.GrowWithMe.ResourceNotFoundException;
import com.example.GrowWithMe.goal.Goal;
import com.example.GrowWithMe.goal.GoalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    private GoalRepository goalRepository;

    @Mock
    private PostRepository postRepository;


    @InjectMocks
    private PostService postService;


    private void assertThrowsGoalNotFoundException(Long id, Runnable serviceMethod){
        when(goalRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(
                ResourceNotFoundException.class,
                serviceMethod::run,
                "goal not found"
        );
    }

    @Test
    public void PostService_CreatePost_throwsErrorIfGoalNotFound(){
        PostRequest postRequest = new PostRequest();
        postRequest.setContent("just finished modelling the kitchen");
        postRequest.setGoalId(1L);

        assertThrowsGoalNotFoundException(postRequest.getGoalId(), () -> postService.createPost(postRequest));
    }
    @Test
    public void PostService_CreatePost(){
        Goal mockGoal = Mockito.mock(Goal.class);

        PostRequest postRequest = new PostRequest();
        postRequest.setContent("just finished modelling the kitchen");
        postRequest.setGoalId(1L);


        when(goalRepository.findById(postRequest.getGoalId())).thenReturn(Optional.of(mockGoal));

        postService.createPost(postRequest);

        verify(postRepository, times(1)).save(Mockito.any(Post.class));
    }

    @Test
    public void PostService_GetPostWithGoalId_ThrowErrorGoalIdNotFound(){
        Long goalId = 1L;
        assertThrowsGoalNotFoundException(goalId, () -> postService.getPostsForGoal(goalId));
    }

    @Test
    public void PostService_GetPostWithGoalId_ReturnGoal(){
        Long goalId = 3L;
        Goal goal = new Goal();
        goal.setId(3L);
        goal.setName("Code hundred hours");
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
    }

}
