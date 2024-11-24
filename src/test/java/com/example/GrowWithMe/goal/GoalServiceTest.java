package com.example.GrowWithMe.goal;


import com.example.GrowWithMe.goal.model.Goal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;

@ActiveProfiles(value = "test")
@ExtendWith(MockitoExtension.class)
public class GoalServiceTest {

    @Mock
    private GoalRepository goalRepository;


    @InjectMocks
    private GoalService goalService;

    @Test
    void shouldCreateGoal(){
        Goal newGoal = new Goal();
        newGoal.setName("renovate my house");

        goalService.add(newGoal);
        verify(goalRepository).save(newGoal);

    }


}
