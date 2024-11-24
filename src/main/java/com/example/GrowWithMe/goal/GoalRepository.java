package com.example.GrowWithMe.goal;

import com.example.GrowWithMe.goal.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
}
