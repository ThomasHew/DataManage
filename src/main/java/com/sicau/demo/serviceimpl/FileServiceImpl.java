package com.sicau.demo.serviceimpl;

import com.sicau.demo.dao.FileDao;
import com.sicau.demo.entity.Files;
import com.sicau.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;

    @Override
    public boolean uploadFile(Files files) {
        return fileDao.uploadFile(files);
    }
}
