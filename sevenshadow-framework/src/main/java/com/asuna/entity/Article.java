package com.asuna.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 文章表(Article)实体类
 *
 * @author makejava
 * @since 2022-09-16 15:39:06
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Article implements Serializable {

    private Long id;     
    private String title; /** 标题 */    
    private String content; /** 文章内容 */    
    private String summary; /** 文章摘要 */    
    private Long categoryId; /** 所属分类id */    
    private String thumbnail; /** 缩略图 */    
    private String isTop; /** 是否置顶（0否，1是） */    
    private String status; /** 状态（0已发布，1草稿） */    
    private Long viewCount; /** 访问量 */    
    private String isComment; /** 是否允许评论 1是，0否 */    
    private Long createBy;     
    private Date createTime;     
    private Long updateBy;     
    private Date updateTime;     
    private Integer delFlag; /** 删除标志（0代表未删除，1代表已删除） */

    public Article(Long id, Long viewCount){
        this.id = id;
        this.viewCount = viewCount;
    }
}

