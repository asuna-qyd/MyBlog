package com.asuna.controller;

import com.asuna.entity.Comment;
import com.asuna.service.ICommentService;
import com.asuna.utils.ResponseResult;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @GetMapping("/commentList")
    public ResponseResult getCommentList(Long articleId, Integer pageNum, Integer pageSize){

        return commentService.getCommentList(articleId, pageNum, pageSize);
    }

    @PostMapping
    public ResponseResult addComment(@RequestBody Comment comment){

        return commentService.addComment(comment);
    }

    @GetMapping("/linkCommentList")
    public ResponseResult getLinkCommentList(Integer pageNum, Integer pageSize) {

        return commentService.getLinkCommentList(pageNum, pageSize);
    }
}
