package com.asuna.mapper;

import com.asuna.entity.Comment;
import com.asuna.vo.CommentChildrenVo;
import com.asuna.vo.CommentVo;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CommentMapperTests {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void getCommentList(){
        List<CommentVo> list = commentMapper.getCommentList(1L, 1, 4);
        for (CommentVo commentVo : list) {
            System.out.println(commentVo);
        }
    }

    @Test
    public void getCommentChildrenList(){
        List<CommentChildrenVo> list = commentMapper.getCommentChildrenList(1L, 1L);
        for (CommentChildrenVo commentVo : list) {
            System.out.println(commentVo);
        }
    }

    @Test
    public void selectAllComment(){
        Long list = commentMapper.selectAllComment(1L);
        System.out.println(list);

    }

    @Test
    public void addComment() {
        Comment comment = new Comment();
        comment.setContent("1111");
        commentMapper.addComment(comment);
    }
}
