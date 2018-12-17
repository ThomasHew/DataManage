package com.sicau.demo.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Files {

    private Integer id;
    private String groupName;
    private String tureFileName;
    private String fileDescription;
    private String uploadIp;
    private Timestamp updateTime;
    private Date uploadTime;
    private String userName;
    private String customizeFileName;
    private Integer fileView;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getUploadIp() {
        return uploadIp;
    }

    public void setUploadIp(String uploadIp) {
        this.uploadIp = uploadIp;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCustomizeFileName() {
        return customizeFileName;
    }

    public void setCustomizeFileName(String customizeFileName) {
        this.customizeFileName = customizeFileName;
    }

    public Integer getFileView() {
        return fileView;
    }

    public void setFileView(Integer fileView) {
        this.fileView = fileView;
    }

    public Files(Integer id, String groupName, String tureFileName, String fileDescription, String uploadIp, Date uploadTime, String userName, String customizeFileName, Integer fileView) {
        this.id = id;
        this.groupName = groupName;
        this.tureFileName = tureFileName;
        this.fileDescription = fileDescription;
        this.uploadIp = uploadIp;
        this.uploadTime = uploadTime;
        this.userName = userName;
        this.customizeFileName = customizeFileName;
        this.fileView = fileView;
    }

    public Files() {
    }
}
