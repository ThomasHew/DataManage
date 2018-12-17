package com.sicau.demo.dao;

import com.sicau.demo.entity.Files;

public interface FileDao {
    //用户上传文件
    boolean uploadFile(Files files);

}
