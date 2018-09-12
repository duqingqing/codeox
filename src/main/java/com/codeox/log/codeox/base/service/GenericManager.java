package com.codeox.log.codeox.base.service;

import com.codeox.log.codeox.base.domain.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface GenericManager<T extends BaseEntity, PK extends Serializable> {
    public void delete(PK id);
    public List<T> findAll();
    public Page<T> findAll(Pageable page);
    public T findById(PK id);
    public List<T> save(Iterable<T> entities);
    public T save(T entity);
}

