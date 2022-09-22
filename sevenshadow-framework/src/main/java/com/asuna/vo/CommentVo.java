package com.asuna.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVo {

    private Long articleId; /** 文章id */
    private List<CommentChildrenVo> children;
    private String content; /** 评论内容 */
    private Long createBy;
    private Date createTime;
    private Long id;
    private Long rootId; /** 根评论id */
    private Long toCommentUserId; /** 所回复的目标评论的userid */
    private Long toCommentId; /** 回复目标评论id */
    private String username;
}
