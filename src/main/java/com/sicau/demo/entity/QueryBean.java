package com.sicau.demo.entity;

public class QueryBean {
    private String tureFileName;
    private String groupName;

    private Integer pageSize = 10;
    private Integer currentRow;
    private Integer currentPage =1;

    public String getTureFileName() {
        return tureFileName;
    }

    public void setTureFileName(String tureFileName) {
        this.tureFileName = tureFileName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(Integer currentRow) {
        this.currentRow = currentRow;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "QueryBean{" +
                "tureFileName='" + tureFileName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", pageSize=" + pageSize +
                ", currentRow=" + currentRow +
                ", currentPage=" + currentPage +
                '}';
    }
}

