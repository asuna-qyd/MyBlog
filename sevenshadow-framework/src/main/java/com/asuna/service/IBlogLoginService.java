package com.asuna.service;

import com.asuna.entity.User;
import com.asuna.utils.ResponseResult;

public interface IBlogLoginService {

    ResponseResult login(User user);

    ResponseResult logout();

}
