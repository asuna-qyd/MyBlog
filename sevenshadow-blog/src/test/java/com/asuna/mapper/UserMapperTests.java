package com.asuna.mapper;

import com.asuna.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectOne() {
        User result = userMapper.selectOne("sg");
        System.out.println(result);
    }

    @Test
    public void getConnection() {
        Jedis jedis = new Jedis("124.222.121.212",6379);
        System.out.println(jedis.ping());
    }

    @Test
    public void findUsernameById() {
        String niceName = userMapper.findNiceNameById(1L);
        System.out.println(niceName);
    }
}
