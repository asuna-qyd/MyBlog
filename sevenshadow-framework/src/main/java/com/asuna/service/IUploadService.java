package com.asuna.service;

import com.asuna.utils.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

    ResponseResult uploadImg(MultipartFile img);
}
