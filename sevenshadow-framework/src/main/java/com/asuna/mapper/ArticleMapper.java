package com.asuna.mapper;

import com.asuna.vo.ArticleDetailVo;
import com.asuna.vo.ArticleListVo;
import com.asuna.vo.HotArticleVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.asuna.entity.Article;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    List<HotArticleVo> findHotArticle();

    List<Integer> findCategoryId();

    List<ArticleListVo> findArticleListCateGoryId(@Param("pageNum") int pageNum,
                                        @Param("pageSize") int pageSize,
                                        @Param("categoryId") long categoryId);

    List<ArticleListVo> findArticleList(@Param("pageNum") int pageNum,
                                        @Param("pageSize") int pageSize);

    Long findCategoryIdById(Long id);

    List<Integer> selectAll();

    List<Integer> selectAllByCategoryId(@Param("categoryId") long categoryId);

    ArticleDetailVo getArticleDetail(Long id);

    Integer updateViewCount(@Param("id") Long id,
                            @Param("viewCount")Long viewCount);

    List<Article> selectAllArticle();

}
