package com.example.GrowWithMe.likes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {

    public Like findPostByIdAndUserId(Long post_id, Long user_id);
}
