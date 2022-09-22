package com.asuna.service.impl;

import com.asuna.mapper.LinkMapper;
import com.asuna.service.ILinkService;
import com.asuna.utils.ResponseResult;
import com.asuna.vo.LinkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    private LinkMapper linkMapper;

    public ResponseResult getAllLink(){

        List<LinkVo> result = linkMapper.getAllLink();
        return ResponseResult.okResult(result);
    }
}
