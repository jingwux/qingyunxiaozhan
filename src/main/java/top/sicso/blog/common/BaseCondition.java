package top.sicso.blog.common;

import lombok.Data;

@Data
public class BaseCondition {

    private int pageIndex = 0;

    private int pageSize = 15;

    private String order;

    private String sort;

    public void setSort(String sort) {
        this.sort = sort.toUpperCase();
    }
}
