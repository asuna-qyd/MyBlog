package com.asuna.service.impl;

import com.asuna.mapper.ArticleMapper;
import com.asuna.mapper.CategoryMapper;
import com.asuna.service.ICategoryService;
import com.asuna.utils.ResponseResult;
import com.asuna.vo.CategoryVo;
import entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ResponseResult getCategoryList() {
        List<Integer> list = articleMapper.findCategoryId();
        List<CategoryVo> result = categoryMapper.getCategoryList(list);
        return ResponseResult.okResult(result);
    }
}
