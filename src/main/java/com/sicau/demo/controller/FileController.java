package com.sicau.demo.controller;

import com.sicau.demo.entity.Files;
import com.sicau.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("file")
public class FileController {
        @Autowired
    private FileService fileService;
        //用户上传文件
    @RequestMapping(value = "uploadfile",method = RequestMethod.POST)
        public String uploadFile(@RequestParam("file")MultipartFile file, Files files, HttpServletRequest request, Model model){
        //获得当前系统时间
        try {
        Date date = new Date();
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Date mysqltime1 = Timestamp.valueOf(nowTime);//把时间转换 
        String uploadIp = request.getRemoteAddr();
        String path = request.getServletContext().getRealPath("/WEB-INF/upload");
        long timestamps = System.currentTimeMillis();
        Random random = new Random();
        int end3 = random.nextInt(999);
        String customizeFileName = String.format("%03d", end3) + timestamps;//str长度为16
        File targetFile = new File(path,customizeFileName);
        String tureFileName = file.getOriginalFilename();
        if (!targetFile.exists()) {
            targetFile.mkdirs();
            Files files1 = new Files(null,files.getGroupName(),tureFileName, files.getFileDescription(),uploadIp,mysqltime1,files.getUserName(),files.getCustomizeFileName(),0);
            fileService.uploadFile(files1);
            file.transferTo(targetFile);//上传到服务器
        }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "success";
        }
}
