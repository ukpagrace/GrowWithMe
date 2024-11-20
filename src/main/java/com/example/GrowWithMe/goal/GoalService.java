package com.example.GrowWithMe.goal;


import org.springframework.stereotype.Service;

@Service
public class GoalService {

    private GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository){
        this.goalRepository = goalRepository;
    }
    public void add(Goal goal) {
        this.goalRepository.save(goal);
    }
}
