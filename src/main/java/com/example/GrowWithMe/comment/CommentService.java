package com.example.GrowWithMe.comment;


import com.example.GrowWithMe.ResourceNotFoundException;
import com.example.GrowWithMe.post.Post;
import com.example.GrowWithMe.post.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    CommentRepository commentRepository;
    PostRepository postRepository;
    public CommentService(
            CommentRepository commentRepository,
            PostRepository postRepository
    ) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public void createComment(CommentRequest commentRequest) {
       Post post =  this.postRepository.findById(commentRequest.getPostId())
                .orElseThrow(() -> new ResourceNotFoundException("post not found"));

        Comment comment = new Comment();
        comment.setContent(commentRequest.getComment());
        comment.setParentId(commentRequest.getParentId());
        comment.setPost(post);

        commentRepository.save(comment);

    }

    public void editComment(Long id, CommentRequest commentRequest) {
        this.postRepository.findById(commentRequest.getPostId())
                .orElseThrow(() -> new ResourceNotFoundException("post not found"));
        Comment comment = this.commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("comment with id" + id + "not found"));

        comment.setContent(commentRequest.getComment());
    }


    public List<Comment> getCommentForPost(Long postId) {
        return this.commentRepository.getCommentsByPost(postId);
    }

    public void deleteComment(Long commentId) {
        this.commentRepository.deleteComment(commentId);
    }
}
