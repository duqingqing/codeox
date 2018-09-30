package com.codeox.log.codeox.repository;

import com.codeox.log.codeox.base.dao.GenericDao;
import com.codeox.log.codeox.domain.Category;
import org.springframework.stereotype.Repository;

/**
 * @autor : duqingqing
 * @data : 2018/9/30 0030
 * @time: 19:35
 * @package: com.codeox.log.codeox.repository
 */
@Repository
public interface CategoryRepository extends GenericDao<Category,Long> {
    Category findByName(String name);
}
