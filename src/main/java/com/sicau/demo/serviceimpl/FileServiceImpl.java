package com.sicau.demo.serviceimpl;

import com.sicau.demo.dao.FileDao;
import com.sicau.demo.entity.FileList;
import com.sicau.demo.entity.Files;
import com.sicau.demo.entity.QueryBean;
import com.sicau.demo.service.FileService;
import com.sicau.demo.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;

    @Override
    public boolean uploadFile(Files files) {
        return fileDao.uploadFile(files);
    }

    @Override
    public Integer getTotalFilesCount(QueryBean queryBean) {
        return fileDao.getTotalFilesCount(queryBean);
    }

    @Override
    public Page<FileList> getFileListByQueryBean(QueryBean queryBean) {
        //获得总记录数
        int totalCount = fileDao.getTotalFilesCount(queryBean);
        //计算分页数开始
        int currentRow = (queryBean.getCurrentPage() - 1) * queryBean.getPageSize();
        queryBean.setCurrentRow(currentRow);
        //计算总页数
        int totalPage = (int) Math.ceil(totalCount * 1.0 / queryBean.getPageSize());

        List<FileList> fileList = fileDao.getFileListByQueryBean(queryBean);

        Page<FileList> page = new Page<>(totalCount,queryBean.getCurrentPage(),queryBean.getPageSize(),totalPage,fileList);

        return page;
    }

    @Override
    public Integer downloadcount(Integer id) {
        return fileDao.downloadcount(id);
    }

    @Override
    public boolean deleteFileById(Integer id) {
        return fileDao.deleteFileById(id);
    }

    //修改文件详情
    @Override
    public boolean modifyFileById(Integer id,String fileDescription) {
        return fileDao.modifyFileById(id,fileDescription);
    }

    @Override
    public Files queryFilesById(Integer id) {
        return fileDao.queryFilesById(id);
    }
}
