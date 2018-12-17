package com.sicau.demo.dao;

import com.sicau.demo.entity.FileList;
import com.sicau.demo.entity.Files;
import com.sicau.demo.entity.QueryBean;

import java.util.List;

public interface FileDao {
    //用户上传文件
    boolean uploadFile(Files files);

    //获得总记录数
    Integer getTotalFilesCount(QueryBean queryBean);

    //按条件分页查询
    List<FileList> getFileListByQueryBean(QueryBean queryBean);
}
