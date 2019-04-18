package top.sicso.blog.common;

import lombok.Data;

@Data
public class BaseCondition {

    private int pageIndex;

    private int pageSize;

    private String order;

    private String sort;

    public void setSort(String sort) {
        this.sort = sort.toUpperCase();
    }
}
