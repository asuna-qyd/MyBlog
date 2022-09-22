package com.asuna.mapper;

import com.asuna.vo.CategoryVo;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {

    List<CategoryVo> getCategoryList(List<Integer> id);

    String getCategoryNameById(Long categoryId);

}
