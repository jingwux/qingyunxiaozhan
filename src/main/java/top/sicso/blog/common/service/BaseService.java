package top.sicso.blog.common.service;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


public interface BaseService<T,PK extends Serializable> {

    T insert(T entity);//增加

    void delete(T entity);//删除

    T update(T entity);//修改

    T findById(PK id);//查询

    List<T> findAll();
}