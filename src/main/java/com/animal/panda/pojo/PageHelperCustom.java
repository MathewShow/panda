package com.animal.panda.pojo;

import java.util.List;

/**
 * 分页
 */
public class PageHelperCustom<T> {
    /** 第几页 */
    private Integer pageNum;
    /** 总页数 */
    private Integer pageCount;
    /** 查询起始位置 */
    private Integer start;
    /** 每页展示记录数 */
    private Integer pageSize;
    /** 总记录数 */
    private Long count;
    /** 返回数据 */
    private List<T> list;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if (pageSize==null || pageSize<=0){
            pageSize=10;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        if (pageSize==null || pageSize<1){
            pageSize = 10;
        }
        int remainder = (int)( count % pageSize);//余数
        pageCount = remainder==0?(int)(count/pageSize):(int)(count/pageSize+1);
        
        if (pageNum==null || pageNum<1){
            pageNum = 1;
        }else if (pageNum>pageCount){
            pageNum = pageCount;
        }
        start = (pageNum-1)*pageSize;
        
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "PageHelper{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
