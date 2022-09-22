package com.asuna.service.impl;

import com.asuna.entity.Comment;
import com.asuna.enums.AppHttpCodeEnum;
import com.asuna.mapper.CommentMapper;
import com.asuna.mapper.UserMapper;
import com.asuna.service.ICommentService;
import com.asuna.service.ex.SystemException;
import com.asuna.utils.ResponseResult;
import com.asuna.utils.SecurityUtils;
import com.asuna.vo.CommentChildrenVo;
import com.asuna.vo.CommentVo;
import com.asuna.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.security.Security;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseResult getCommentList(Long articleId, Integer pageNum, Integer pageSize) {

        List<CommentVo> commentList = commentMapper.getCommentList(articleId, pageNum - 1, pageSize);
        Long totals = commentMapper.selectAllComment(articleId);

        for (CommentVo commentVo : commentList) {
            String username = userMapper.findNiceNameById(commentVo.getCreateBy());
            List<CommentChildrenVo> childrenList = commentMapper.getCommentChildrenList(commentVo.getId(), articleId);

            for (CommentChildrenVo commentChildrenVo : childrenList) {
                String childrenName = userMapper.findNiceNameById(commentChildrenVo.getCreateBy());
                commentChildrenVo.setUsername(childrenName);
            }

            commentVo.setChildren(childrenList);
            commentVo.setUsername(username);
        }

        PageVo pageVo = new PageVo();
        pageVo.setRows(commentList);
        pageVo.setTotal(totals);

        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult addComment(Comment comment) {

        if (!StringUtils.hasText(comment.getContent())){
            throw new SystemException(AppHttpCodeEnum.CONTENT_NOT_NULL);
        }

        comment.setCreateBy(SecurityUtils.getUserId());
        comment.setUpdateBy(SecurityUtils.getUserId());
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());
        commentMapper.addComment(comment);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getLinkCommentList(Integer pageNum, Integer pageSize) {

        List<CommentVo> commentList = commentMapper.getLinkCommentList(pageNum - 1, pageSize);
        Long totals = commentMapper.selectAllLinkComment();

        for (CommentVo commentVo : commentList) {
            String username = userMapper.findNiceNameById(commentVo.getCreateBy());
            List<CommentChildrenVo> childrenList = commentMapper.getLinkCommentChildrenList(commentVo.getId());

            for (CommentChildrenVo commentChildrenVo : childrenList) {
                String childrenName = userMapper.findNiceNameById(commentChildrenVo.getCreateBy());
                commentChildrenVo.setUsername(childrenName);
            }

            commentVo.setChildren(childrenList);
            commentVo.setUsername(username);
        }

        PageVo pageVo = new PageVo();
        pageVo.setRows(commentList);
        pageVo.setTotal(totals);

        return ResponseResult.okResult(pageVo);
    }
}
