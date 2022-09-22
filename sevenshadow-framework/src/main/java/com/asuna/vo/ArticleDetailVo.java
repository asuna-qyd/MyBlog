package com.asuna.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDetailVo {

    private Long id;
    private Long categoryId; /** 所属分类id */
    private String categoryName; /** 所属分类名称 */
    private String content; /** 文章内容 */
    private Date createTime;
    private String isComment; /** 是否允许评论 1是，0否 */
    private String title; /** 标题 */
    private Long viewCount; /** 访问量 */

}
