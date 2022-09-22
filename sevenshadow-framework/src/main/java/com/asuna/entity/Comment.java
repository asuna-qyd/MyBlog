package com.asuna.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 评论表(Comment)实体类
 *
 * @author makejava
 * @since 2022-09-18 15:20:10
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment implements Serializable {

    private Long id;     
    private String type; /** 评论类型（0代表文章评论，1代表友链评论） */    
    private Long articleId; /** 文章id */    
    private Long rootId; /** 根评论id */    
    private String content; /** 评论内容 */    
    private Long toCommentUserId; /** 所回复的目标评论的userid */    
    private Long toCommentId; /** 回复目标评论id */

    @TableField(fill = FieldFill.INSERT)
    private Long createBy; /** 创建人的用户id */

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;/** 创建时间 */

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;/** 更新人 */

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime; /** 更新时间 */

    private Integer delFlag; /** 删除标志（0代表未删除，1代表已删除） */    
}

