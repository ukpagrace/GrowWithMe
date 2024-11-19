package com.example.GrowWithMe.goal;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoalController {

    @PostMapping()
    public void createGoal(@RequestBody Goal goal){


    }
}
