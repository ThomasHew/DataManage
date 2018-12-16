package com.sicau.demo.entity;

public class User {
    private int id;
    private String userName;
    private String userPwd;
    private String userGroup;
    private String userClass;
    private String userTel;
    private Integer isAdmin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass = userClass;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public User(int id, String userName, String userPwd, String userGroup, String userClass, String userTel, Integer isAdmin) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userGroup = userGroup;
        this.userClass = userClass;
        this.userTel = userTel;
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userGroup='" + userGroup + '\'' +
                ", userClass='" + userClass + '\'' +
                ", userTel='" + userTel + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public User() {
    }
}
