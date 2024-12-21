package com.lijin.study.springcloud.service.dao.mybatis;

public class BaseExample {

    private int startNum; // 起始页
    private int pageSize; // 每页条数
    private boolean isPagination = false;

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
        this.isPagination = true;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isPagination() {
        return isPagination;
    }
}
