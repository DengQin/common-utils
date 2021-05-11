package com.dengqin.utils.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dq on 2020/11/25
 */
@ApiModel(value = "分页数据")
public class Page<T> implements Serializable {

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer currentPage;

    /**
     * 分页大小
     */
    @ApiModelProperty(value = "分页大小")
    private Integer pageSize;

    /**
     * 总记录数
     */
    @ApiModelProperty(value = "总记录数")
    private Integer totalCount;

    /**
     * 是否最后一页
     */
    @ApiModelProperty(value = "是否最后一页")
    private Boolean isStop;

    /**
     * 游标查询id
     */
    @ApiModelProperty(value = "游标id")
    private String cursorId;

    /**
     * 当前页的记录
     */
    @ApiModelProperty(value = "分页数据")
    private List<T> data;

    public Page() {
    }

    public Page(Page<?> page) {
        this(page.getCurrentPage(), page.getTotalCount(), page.getPageSize());
    }

    public Page(Integer currentPage, Integer pageSize, Integer totalCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getStop() {
        return isStop;
    }

    public void setStop(Boolean stop) {
        isStop = stop;
    }

    public String getCursorId() {
        return cursorId;
    }

    public void setCursorId(String cursorId) {
        this.cursorId = cursorId;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * 获取总页数
     */
    public Integer getAllPageNum() {
        if (totalCount != null && pageSize != null && pageSize != 0) {
            return (this.totalCount - 1) / this.pageSize + 1;
        }
        return null;
    }
}
