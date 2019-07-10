package top.sicso.blog.common.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import top.sicso.blog.common.service.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


public abstract class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

    protected abstract JpaRepository<T, PK> getRepository();

    @Override
    public T insert(T entity) {
        return this.getRepository().save(entity);
    }

    @Override
    public void delete(T entity) {
        this.getRepository().delete(entity);
    }

    @Override
    public T update(T entity) {
        return this.getRepository().saveAndFlush(entity);
    }

    @Override
    public T findById(PK id) {
        return this.getRepository().findById(id).get();
    }

    @Override
    public List<T> findAll() {
        return this.getRepository().findAll();
    }
}
