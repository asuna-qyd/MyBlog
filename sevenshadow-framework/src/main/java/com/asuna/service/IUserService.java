package com.asuna.service;

import com.asuna.entity.User;
import com.asuna.utils.ResponseResult;

public interface IUserService {

    ResponseResult userInfo();
    ResponseResult updateUserInfo(User user);
    ResponseResult register(User user);
}
