package com.asuna.service.impl;

import com.asuna.entity.Article;
import com.asuna.enums.AppHttpCodeEnum;
import com.asuna.mapper.ArticleMapper;
import com.asuna.mapper.CategoryMapper;
import com.asuna.service.IArticleService;
import com.asuna.service.ex.SystemException;
import com.asuna.utils.RedisCache;
import com.asuna.utils.ResponseResult;
import com.asuna.vo.ArticleDetailVo;
import com.asuna.vo.ArticleListVo;
import com.asuna.vo.HotArticleVo;
import com.asuna.vo.PageVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult hotArticleList() {

        List<HotArticleVo> list = articleMapper.findHotArticle();
        return ResponseResult.okResult(list);
    }

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {

        /**
         * 判断是否是分类页面查询
         */
        List<ArticleListVo> result ;
        PageVo pageVo = new PageVo();
        List<Integer> list;
        System.out.println("categoryId: " + categoryId);
        if (categoryId == 0){
            result = articleMapper.findArticleList(pageNum - 1, pageSize);
            list = articleMapper.selectAll();
        }else {
            result = articleMapper.findArticleListCateGoryId(pageNum - 1, pageSize, categoryId);
            list = articleMapper.selectAllByCategoryId(categoryId);
        }

        for (ArticleListVo articleListVo : result) {
            Long newCategoryId = articleMapper.findCategoryIdById(articleListVo.getId());
            articleListVo.setCategoryName(categoryMapper.getCategoryNameById(newCategoryId));
        }

        pageVo.setRows(result);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(list);
        pageVo.setTotal(pageInfo.getTotal());

        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult getArticleDetail(Long id) {

        ArticleDetailVo result = articleMapper.getArticleDetail(id);

        //从redis中获取viewCount
        Integer viewCount = redisCache.getCacheMapValue("article:viewCount", id.toString());
        result.setViewCount(viewCount.longValue());

        result.setCategoryName(categoryMapper.getCategoryNameById(result.getCategoryId()));
        return ResponseResult.okResult(result);
    }

    @Override
    public ResponseResult updateViewCount(Long id) {

        //更新redis中对应 id的浏览量
        redisCache.incrementCacheMapValue("article:viewCount",id.toString(),1);
        return ResponseResult.okResult();
    }

    @Override
    public void updateBatchById(List<Article> articles) {
        for (Article article : articles) {
            Integer rows = articleMapper.updateViewCount(article.getId(), article.getViewCount());
            if (rows < 1) {
                throw new SystemException(AppHttpCodeEnum.SYSTEM_ERROR);
            }
        }
    }
}
