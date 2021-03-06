package com.sicau.demo.controller;

import com.sicau.demo.entity.FileList;
import com.sicau.demo.entity.Files;
import com.sicau.demo.entity.QueryBean;
import com.sicau.demo.entity.QueryCondition;
import com.sicau.demo.service.FileService;
import com.sicau.demo.utils.Page;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("file")
@SessionAttributes("queryCondition")
public class FileController {
    @Autowired
    private FileService fileService;

    //分页
    @RequestMapping("tofilelist")
    public String page(HttpServletRequest request, QueryBean queryBean, QueryCondition queryCondition){

        if (request.getSession().getAttribute("querycondition")==null){
            request.getSession().setAttribute("querycondition",queryCondition);
        }
        QueryCondition querycondition =(QueryCondition) request.getAttribute("querycondition");
        queryBean.setGroupName(queryCondition.getGroupName());
        queryBean.setTureFileName(queryCondition.getTureFileName());
        Page<FileList> page = fileService.getFileListByQueryBean(queryBean);
        request.setAttribute("page",page);

        return "index";

    }



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
            System.out.println(files);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
            Files files1 = new Files(null,files.getGroupName(),tureFileName, files.getFileDescription(),uploadIp,mysqltime1,files.getUserName(),customizeFileName,0);
           boolean flag =  fileService.uploadFile(files1);
            System.out.println(flag);
            file.transferTo(targetFile);//上传到服务器
        }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/file/tofilelist.html";
        }
    //文件下载
    @RequestMapping("download")
    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("id") Integer id)
            throws Exception {
        // 下载文件路径
        String path = request.getServletContext().getRealPath("/WEB-INF/upload");
        Files files1 = fileService.queryFilesById(id);
        File file = new File(path + File.separator + files1.getCustomizeFileName());
       // 记录下载次数
        fileService.downloadcount(id);
        // 通知浏览器以attachment（下载方式）
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(files1.getTureFileName().getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //转成字节数组下载
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);

    }

    //删除文件
    @RequestMapping("deletefile")
    @ResponseBody
    public String Deletefile(HttpServletResponse response,HttpServletRequest request,Integer id){
        String path = request.getServletContext().getRealPath("/WEB-INF/upload");
        Files files1 = fileService.queryFilesById(id);
        File file = new File(path + File.separator + files1.getCustomizeFileName());
        file.delete();
       boolean flag1 = fileService.deleteFileById(id);
        System.out.println(flag1);
        try {
            fileService.deleteFileById(id);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "index";
    }

    //修改文件
    @RequestMapping("updatefile")
    public String Updatefile(Integer id,String fileDescription){
        System.out.println("修改前");
        boolean flag2 = fileService.modifyFileById(id,fileDescription);
        System.out.println(id+fileDescription);
        System.out.println("修改后");
    if (flag2)
        System.out.println("文件详情更改成功");
        return "redirect:/file/tofilelist.html";
    }
    //跳转到文件详情页面，可进行文件描述的修改
    @RequestMapping("toupdatefile")
    public String Toupdatefile(HttpServletRequest request,Integer id){
       Files files1 = fileService.queryFilesById(id);

        request.setAttribute("checkfile",files1);
        return "modifyfile";
    }

            //跳转到上传文件页面
    @RequestMapping("touploadfile")
    public String Touploadfile(){
        return "upload";
    }
}
