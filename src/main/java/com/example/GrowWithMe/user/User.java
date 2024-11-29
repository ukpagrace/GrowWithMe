package com.example.GrowWithMe.user;

import com.example.GrowWithMe.goal.model.Goal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class User {

    @Id
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "user_goals")
    private List<Goal> userGoals;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "followed_goals",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "goal_id", referencedColumnName = "id"
            )
    )
    private List<Goal> followedGoals;
}
