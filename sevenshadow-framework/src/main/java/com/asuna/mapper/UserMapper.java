package com.asuna.mapper;

import com.asuna.entity.User;
import com.asuna.vo.UserInfoVo;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User selectOne(String username);

    String findNiceNameById(Long id);

    UserInfoVo userInfo(Long userId);

    Integer updateUserInfo(User user);

    Integer UserNameExist(String username);

    Integer NickNameExist(String nickname);

    Integer EmailExist(String email);

    Integer InsertUser(User user);
}
