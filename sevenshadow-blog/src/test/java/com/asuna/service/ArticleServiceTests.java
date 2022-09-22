package com.asuna.service;

import com.asuna.utils.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArticleServiceTests {

    @Autowired
    private IArticleService articleService;

    @Test
    public void hotArticleList() {
        ResponseResult result = articleService.hotArticleList();
        System.out.println(result);
    }

    @Test
    public void articleList() {
        ResponseResult result = articleService.articleList(0, 2, null);
        System.out.println(result);
    }
}
