package com.sicau.demo.controller;

import com.sicau.demo.entity.FileList;
import com.sicau.demo.entity.Files;
import com.sicau.demo.entity.QueryBean;
import com.sicau.demo.entity.QueryCondition;
import com.sicau.demo.service.FileService;
import com.sicau.demo.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
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
            System.out.println("文件上传路径"+path);
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
            System.out.println("这是构造函数之后"+files1);
           boolean flag =  fileService.uploadFile(files1);
            System.out.println(flag);
            file.transferTo(targetFile);//上传到服务器
        }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "index";
        }
    //文件下载
    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") Integer id)
            throws Exception {
        // 下载文件路径
        String path = request.getServletContext().getRealPath("/WEB-INF/upload");
        Files files1 = fileService.queryFilesById(id);
        File file = new File(path + File.separator + files1.getCustomizeFileName());
      /*  HttpHeaders headers = new HttpHeaders();*/
        // 下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(files1.getTureFileName().getBytes("UTF-8"), "iso-8859-1");
        // 记录下载次数
        fileService.downloadcount(id);
        // 通知浏览器以attachment（下载方式）
        // headers.setContentDispositionFormData("attachment", downloadFielName);
        // // application/octet-stream ： 二进制流数据（最常见的文件下载）
        // headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        response.reset();
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("content-disposition",
                "attachment;filename=" + downloadFielName);
        InputStream in = new BufferedInputStream(new FileInputStream(file), 4096);
        OutputStream os = new BufferedOutputStream(response.getOutputStream());
        // cache
        byte[] cache = new byte[4096];
        int len = -1;
        while ((len = in.read(cache)) != -1) {
            os.write(cache, 0, len);
            os.flush();
        }
        os.close();
    }

    //删除文件
    @RequestMapping("deletefile")
    public String Deletefile(HttpServletRequest request,Integer id){
        String path = request.getServletContext().getRealPath("/WEB-INF/upload");
        Files files1 = fileService.queryFilesById(id);
        File file = new File(path + File.separator + files1.getCustomizeFileName());
        file.delete();
        fileService.deleteFileById(id);
        return "index";
    }

    //修改文件
    @RequestMapping("updatefile")
    public String Updatefile(Integer id){

        return "index";
    }

            //跳转到上传文件页面
    @RequestMapping("touploadfile")
    public String Touploadfile(){
        return "upload";
    }
}
