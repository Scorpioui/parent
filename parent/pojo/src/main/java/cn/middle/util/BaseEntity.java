package cn.middle.util;

import java.io.Serializable;


/**
 * 基础实体类
 */
public class BaseEntity implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 当前页码
     */
    private Integer pageIndex;
    
    /**
     * 每页记录数
     */
    private Integer pageSize;
    
    /**
     * 排序字段
     */
    private String orderBy;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
    
}