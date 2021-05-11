package com.dengqin.utils.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "分页查询")
public class PagedQuery implements Serializable {

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer currentPage = 1;

    /**
     * 分页大小
     */
    @ApiModelProperty(value = "分页大小")
    private Integer pageSize = 10;

    /**
     * 开始条数
     */
    @ApiModelProperty(value = "开始条数")
    private Integer startRow;

    /**
     * 是否分页
     */
    @ApiModelProperty(value = "是否分页")
    protected boolean isPaged = true;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        if (!isPaged) {
            return null;
        }

        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartRow() {
        if (!isPaged) {
            return null;
        }

        if (currentPage == null || currentPage < 1 || pageSize == null || pageSize < 1) {
            return 0;
        }
        startRow = (currentPage - 1) * pageSize;
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }
}
