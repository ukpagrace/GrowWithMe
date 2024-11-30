package com.example.GrowWithMe.goal.model;


import com.example.GrowWithMe.post.Post;
import com.example.GrowWithMe.tag.Tag;
import com.example.GrowWithMe.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank(message = "Name is mandatory")
    private String title;
    
    @Column(length = 200)
    private String description;
    
    @Column(length = 100)
    private String image;

//    @Column(name = "user_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "goal_subscribers",
            joinColumns = @JoinColumn(
                    name = "goal_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"
            )
    )
    private List<User> users;
    
    @OneToMany
    private List<Tag> tags;
    
    @Basic
    private int level;
    @Transient
    private GoalStatus goalStatus;

    @OneToMany(mappedBy = "goal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> posts;
    
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private LocalDateTime CreatedAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime UpdatedAt;


    @PostLoad
    void fillTransient() {
        if (level == 100) {
            this.goalStatus = GoalStatus.COMPLETED;
        } else if (level == 0) {
            this.goalStatus = GoalStatus.UNSTARTED;
        } else {
            this.goalStatus = GoalStatus.IN_PROGRESS;
        }
    }

    @PrePersist
    void prePersist() {
        if (this.goalStatus != null) {
            this.goalStatus = GoalStatus.of(level);
        }
    }
}
