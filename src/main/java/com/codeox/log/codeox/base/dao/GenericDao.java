package com.codeox.log.codeox.base.dao;


import com.codeox.log.codeox.base.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;


@NoRepositoryBean
public interface GenericDao<T extends BaseEntity, PK extends Serializable>
        extends JpaRepository<T, PK>, JpaSpecificationExecutor<T> {
}
