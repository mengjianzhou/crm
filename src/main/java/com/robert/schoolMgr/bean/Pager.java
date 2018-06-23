package com.robert.schoolMgr.bean;

/**
 * @auth mengjianzhou
 * @Date 2018/4/5
 */
public class Pager {
    /**页码 从1开始*/
    private int pageNo;
    /**每页大小*/
    private int pageSize;

    private int startNo;

    private int endNo;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartNo(){
        return (pageNo-1)*pageSize;
    }

    public int getEndNo(){
        return pageNo*pageSize;
    }

    public void setStartNo(int startNo) {
        this.startNo = startNo;
    }

    public void setEndNo(int endNo) {
        this.endNo = endNo;
    }
}
