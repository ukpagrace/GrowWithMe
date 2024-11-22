package com.example.GrowWithMe.comment;


import com.example.GrowWithMe.post.PostRequest;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public void getCommentsForPost(@PathVariable Long postId){
        commentService.getCommentForPost(postId);
    }
}
