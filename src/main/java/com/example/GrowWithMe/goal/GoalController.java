package com.example.GrowWithMe.goal;


import com.example.GrowWithMe.goal.model.Goal;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/v1/goals")
public class GoalController {
    private final GoalService goalService;

    public GoalController(GoalService goalService){
        this.goalService = goalService;
    }


    @PostMapping()
    public ResponseEntity<String> createGoal(@Valid @RequestBody Goal goal){
        goalService.add(goal);
        return new ResponseEntity<String>("Goal created successfully", HttpStatus.CREATED);
    }
}
