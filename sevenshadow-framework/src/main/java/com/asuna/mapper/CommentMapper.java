package com.asuna.mapper;

import com.asuna.entity.Comment;
import com.asuna.vo.CommentChildrenVo;
import com.asuna.vo.CommentVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {

    List<CommentVo> getCommentList(@Param("articleId") Long articleId,
                                   @Param("pageNum") Integer pageNum,
                                   @Param("pageSize") Integer pageSize);

    List<CommentChildrenVo> getCommentChildrenList(@Param("rootId") Long rootId,
                                                   @Param("articleId") Long articleId);

    Long selectAllComment(@Param("articleId") Long articleId);

    Integer addComment(Comment comment);

    List<CommentVo> getLinkCommentList(@Param("pageNum") Integer pageNum,
                                   @Param("pageSize") Integer pageSize);

    List<CommentChildrenVo> getLinkCommentChildrenList(@Param("rootId") Long rootId);

    Long selectAllLinkComment();
}
