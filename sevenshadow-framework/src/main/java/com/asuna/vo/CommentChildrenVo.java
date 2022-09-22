package com.asuna.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentChildrenVo {

    private Long id;
    private Long articleId; /** 文章id */
    private Long rootId; /** 根评论id */
    private String content; /** 评论内容 */
    private Long toCommentUserId; /** 所回复的目标评论的userid */
    private Long toCommentId; /** 回复目标评论id */
    private Long createBy;
    private Date createTime;
    private String toCommentUserName;
    private String username;


}
