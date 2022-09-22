package com.asuna.mapper;

import com.asuna.vo.LinkVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkMapper {

    List<LinkVo> getAllLink();
}
