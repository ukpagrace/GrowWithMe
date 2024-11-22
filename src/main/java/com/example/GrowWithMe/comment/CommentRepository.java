package com.example.GrowWithMe.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("from Comment where post.id = :postId")
    List<Comment> getCommentsByPost(Long postId);

    @Query("from Comment where id = :commentId and parentId = :commentId")
    void deleteComment(Long commentId);
}
