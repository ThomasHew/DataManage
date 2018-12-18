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

    //查询文件通过ID
    Files queryFilesById(Integer id);

    //记录下载次数
    Integer downloadcount(Integer id);

    //删除文件通过id
    boolean deleteFileById(Integer id);

    //修改文件
    boolean modifyFileById(Integer id,String fileDescription);

}
