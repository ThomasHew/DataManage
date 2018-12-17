package com.sicau.demo.service;

import com.sicau.demo.entity.FileList;
import com.sicau.demo.entity.Files;
import com.sicau.demo.entity.QueryBean;
import com.sicau.demo.utils.Page;

public interface FileService {
    //用户上传文件
    boolean uploadFile(Files files);

    //文件总记录数
    Integer getTotalFilesCount(QueryBean queryBean);
    //按条件分页查询
    Page<FileList> getFileListByQueryBean(QueryBean queryBean);


}
