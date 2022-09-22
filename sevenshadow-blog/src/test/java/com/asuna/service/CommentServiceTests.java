package com.asuna.service;

import com.asuna.mapper.CommentMapper;
import com.asuna.mapper.UserMapper;
import com.asuna.utils.ResponseResult;
import com.asuna.vo.CommentChildrenVo;
import com.asuna.vo.CommentVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CommentServiceTests {

    @Autowired
    private ICommentService commentService;


    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getCommentList() {

        List<CommentVo> commentList = commentMapper.getCommentList(1L, 4, 5);
//        Long totals = commentMapper.selectAllComment(1);

        for (CommentVo commentVo : commentList) {
            String username = userMapper.findNiceNameById(commentVo.getCreateBy());

            List<CommentChildrenVo> childrenList = commentMapper.getCommentChildrenList(commentVo.getId(), 1L);

            for (CommentChildrenVo commentChildrenVo : childrenList) {
                String childrenName = userMapper.findNiceNameById(commentChildrenVo.getCreateBy());
                commentChildrenVo.setUsername(childrenName);
            }

            commentVo.setChildren(childrenList);
            commentVo.setUsername(username);
            System.out.println(commentVo);
        }
    }


}
