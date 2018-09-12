package com.codeox.log.codeox.base.service.impl;

import com.codeox.log.codeox.base.dao.GenericDao;
import com.codeox.log.codeox.base.domain.BaseEntity;
import com.codeox.log.codeox.base.service.GenericManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Transactional
@Service
public class GenericManagerImpl<T extends BaseEntity, PK extends Serializable> implements GenericManager<T, PK> {

    protected GenericDao<T, PK> dao;

    public void delete(PK id) {
        this.dao.deleteById(id);
    }

    public List<T> findAll() {
        return this.dao.findAll();
    }

    public Page<T> findAll(Pageable page) {
        Page<T> result = this.dao.findAll(page);
        return result;
    }

    public T findById(PK id) {
        return this.dao.getOne(id);
    }

    public List<T> save(Iterable<T> entities) {
        return this.dao.saveAll(entities);
    }

    public T save(T entity) {
        return this.dao.saveAndFlush(entity);
    }

}
