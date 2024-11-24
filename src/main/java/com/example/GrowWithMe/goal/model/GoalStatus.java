package com.example.GrowWithMe.goal.model;


public enum GoalStatus {

    COMPLETED(100),
    IN_PROGRESS(),
    ABANDONED(),
    UNSTARTED(0);

    private int goalLevel;

    GoalStatus() {
    }
    GoalStatus(int level) {
        this.goalLevel = level;
    }

    public int getGoalLevel() {
        return this.goalLevel;
    }

    public static GoalStatus of(int level) {
        if (level == 100) return COMPLETED;
        else if (level > 0) return IN_PROGRESS; //How do we account for ABANDONED status??
        else return UNSTARTED;
    }
}
