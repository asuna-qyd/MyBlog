package com.asuna.service;

import com.asuna.utils.ResponseResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.asuna.entity.Article;

import java.util.List;


public interface IArticleService {

    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryId);

    ResponseResult getArticleDetail(Long id);

    ResponseResult updateViewCount(Long id);

    void updateBatchById(List<Article> articles);

}
