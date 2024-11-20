package com.example.GrowWithMe.goal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/v1/goals")
public class GoalController {

    @Autowired
    private final GoalService goalService;

    public GoalController(GoalService goalService){
        this.goalService = goalService;
    }


    @PostMapping()
    public void createGoal(@RequestBody Goal goal){
        goalService.add(goal);
    }
}
