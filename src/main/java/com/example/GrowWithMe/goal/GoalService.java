package com.example.GrowWithMe.goal;


import com.example.GrowWithMe.goal.model.Goal;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository){
        this.goalRepository = goalRepository;
    }
    public void add(Goal goal) {
        this.goalRepository.save(goal);
    }
}
