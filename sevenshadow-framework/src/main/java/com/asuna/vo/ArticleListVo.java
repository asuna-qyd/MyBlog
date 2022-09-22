package com.asuna.vo;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleListVo {

    private Long id;
    private String title; /** 标题 */
    private Date createTime;
//    private Long likeCount;
    private Long viewCount; /** 访问量 */
    private String summary; /** 文章摘要 */
    private String thumbnail; /** 缩略图 */
    private String categoryName; /** 所属分类名 */

}
