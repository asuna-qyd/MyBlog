package com.asuna.controller;

import com.asuna.service.ICategoryService;
import com.asuna.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;


    @GetMapping("/getCategoryList")
    public ResponseResult getCategoryList(){

        return categoryService.getCategoryList();
    }
}
