package com.example.GrowWithMe.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("FROM Post where goal.id = :goalId")
    List<Post> FindAllByGoalId(@Param("goalId") Long goalId);

}
