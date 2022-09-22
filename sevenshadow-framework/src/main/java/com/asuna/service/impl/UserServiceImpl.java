package com.asuna.service.impl;

import com.asuna.entity.User;
import com.asuna.enums.AppHttpCodeEnum;
import com.asuna.mapper.UserMapper;
import com.asuna.service.IUserService;
import com.asuna.service.ex.SystemException;
import com.asuna.utils.ResponseResult;
import com.asuna.utils.SecurityUtils;
import com.asuna.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseResult userInfo() {

        Long userId = SecurityUtils.getUserId();

        UserInfoVo result = userMapper.userInfo(userId);

        return ResponseResult.okResult(result);
    }

    @Override
    public ResponseResult updateUserInfo(User user) {

        Integer result = userMapper.updateUserInfo(user);
        if (result < 1) {
            throw new SystemException(AppHttpCodeEnum.SYSTEM_ERROR);
        }

        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult register(User user) {

        if (!StringUtils.hasText(user.getUserName())) {
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        } else if (!StringUtils.hasText(user.getNickName())) {
            throw new SystemException(AppHttpCodeEnum.NICKNAME_NOT_NULL);
        } else if (!StringUtils.hasText(user.getEmail())) {
            throw new SystemException(AppHttpCodeEnum.EMAIL_NOT_NULL);
        } else if (!StringUtils.hasText(user.getPassword())) {
            throw new SystemException(AppHttpCodeEnum.PASSWORD_NOT_NULL);
        }

        if (userMapper.UserNameExist(user.getUserName()) > 0) {
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        } else if (userMapper.NickNameExist(user.getNickName()) > 0) {
            throw new SystemException(AppHttpCodeEnum.NICKNAME_EXIST);
        } else if (userMapper.EmailExist(user.getEmail()) > 0) {
            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
        }


        user.setCreateTime(new Date());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Integer result = userMapper.InsertUser(user);
        if (result < 0){
            throw new SystemException(AppHttpCodeEnum.SYSTEM_ERROR);
        }

        return ResponseResult.okResult();
    }
}
