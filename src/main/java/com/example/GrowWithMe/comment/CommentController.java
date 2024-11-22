package com.example.GrowWithMe.comment;


import com.example.GrowWithMe.post.PostRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {
    CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public void createComment(@RequestBody CommentRequest commentRequest){
        commentService.createComment(commentRequest);
    }

    @PutMapping("{id}")
    public void editComment(@PathVariable Long id, CommentRequest commentRequest){
        commentService.editComment(id, commentRequest);
    }

    @GetMapping("{postId}")
    public List<Comment> getCommentsForPost(@PathVariable Long postId){
        return commentService.getCommentForPost(postId);
    }

    @DeleteMapping("{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.getCommentForPost(commentId);
    }
}
