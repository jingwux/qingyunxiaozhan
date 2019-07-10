package top.sicso.blog.common;

import lombok.Data;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


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
