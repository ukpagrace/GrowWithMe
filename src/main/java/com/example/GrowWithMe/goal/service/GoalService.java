package com.example.GrowWithMe.goal.service;


import com.example.GrowWithMe.goal.dto.request.CreateGoalRequest;
import com.example.GrowWithMe.goal.dto.response.CreateGoalResponse;
import com.example.GrowWithMe.goal.model.Goal;


public interface GoalService {

    void add(Goal goal); //Should what was saved return void? How do we know if it was indeed saved, and the id?
    CreateGoalResponse createGoal(CreateGoalRequest request); // The essense if so we control what's happening inside our business logic layer
}
