package com.asuna.mapper;

import com.asuna.vo.CategoryVo;
import entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryMapperTests {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void getCategoryList(){
        List<Integer> result = articleMapper.findCategoryId();
        List<CategoryVo> list = categoryMapper.getCategoryList(result);
        for (CategoryVo category : list) {
            System.out.println(category);
        }
    }

    @Test
    public void getCategoryNameById(){
        String result = categoryMapper.getCategoryNameById(1L);
        System.out.println(result);
    }
}
