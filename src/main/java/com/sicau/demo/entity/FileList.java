package com.sicau.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class FileList {

    private Integer id;
    private String fileDescription;
    private String groupName;
    private String tureFileName;
    private String uploadIp;
    private String userName;
    private Date uploadTime;
    private Timestamp updateTime;
    private Integer fileView;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTureFileName() {
        return tureFileName;
    }

    public void setTureFileName(String tureFileName) {
        this.tureFileName = tureFileName;
    }

    public String getUploadIp() {
        return uploadIp;
    }

    public void setUploadIp(String uploadIp) {
        this.uploadIp = uploadIp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getFileView() {
        return fileView;
    }

    public void setFileView(Integer fileView) {
        this.fileView = fileView;
    }
}
