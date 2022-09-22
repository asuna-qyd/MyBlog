package com.asuna.mapper;

import com.asuna.vo.LinkVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LinkMapperTests {

    @Autowired
    private LinkMapper linkMapper;

    @Test
    public void getAllLink() {
        List<LinkVo> result = linkMapper.getAllLink();
        for (LinkVo linkVo : result) {
            System.out.println(linkVo);
        }
    }
}
