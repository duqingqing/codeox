package com.codeox.log.codeox.repository;

import com.codeox.log.codeox.base.dao.GenericDao;
import com.codeox.log.codeox.domain.User;
import org.springframework.stereotype.Repository;


/**
 * @autor : duqingqing
 * @data : 2018/9/12 0012
 * @time: 9:31
 * @package: com.codeox.log.codeox.repository
 */
@Repository
public interface UserRepository extends GenericDao<User,Long>{
    public User findByUsername(String username);
}
