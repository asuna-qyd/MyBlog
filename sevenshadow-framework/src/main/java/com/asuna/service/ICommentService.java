package com.asuna.service;

import com.asuna.entity.Comment;
import com.asuna.utils.ResponseResult;

public interface ICommentService {

    ResponseResult getCommentList(Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);

    ResponseResult getLinkCommentList(Integer pageNum, Integer pageSize);
}
