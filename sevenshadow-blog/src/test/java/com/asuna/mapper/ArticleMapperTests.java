package com.asuna.mapper;

import com.asuna.entity.Article;
import com.asuna.vo.ArticleDetailVo;
import com.asuna.vo.ArticleListVo;
import com.asuna.vo.HotArticleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.plaf.IconUIResource;
import java.util.List;

@SpringBootTest
public class ArticleMapperTests {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void findHotArticle() {

        List<HotArticleVo> result = articleMapper.findHotArticle();
        for (HotArticleVo article : result) {
            System.out.println(article);
        }
    }

    @Test
    public void findCategoryId() {

        List<Integer> result = articleMapper.findCategoryId();
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    @Test
    public void findArticleList() {

        List<ArticleListVo> list = articleMapper.findArticleList(0, 2);
        System.out.println(list);

    }

    @Test
    public void findArticleListCategory() {

        List<ArticleListVo> list = articleMapper.findArticleListCateGoryId(0, 2, 1);
        System.out.println(list);

    }

    @Test
    public void findCategoryIdById(){
        Long result = articleMapper.findCategoryIdById(1L);
        System.out.println(result);
    }

    @Test
    public void getArticleDetail(){
        ArticleDetailVo result = articleMapper.getArticleDetail(1L);
        System.out.println(result);

    }
}
