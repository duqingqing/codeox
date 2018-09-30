package com.codeox.log.codeox.repository;

import com.codeox.log.codeox.base.dao.GenericDao;
import com.codeox.log.codeox.domain.Blog;
import com.codeox.log.codeox.domain.Star;
import com.codeox.log.codeox.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @autor : duqingqing
 * @data : 2018/9/26 0026
 * @time: 18:24
 * @package: com.codeox.log.codeox.repository
 */
@Repository
@Transactional
public interface StarRepository extends GenericDao<Star,Long> {
    @Modifying
    @Query(value = "update Star star set star.status =:status where star.blog=:blog and star.user=:user")
    int updateStar(@Param(value = "blog") Blog blog, @Param(value = "user") User user, @Param(value = "status") int status);

    Star findStarByBlogAndUser(Blog blog,User user);
    
}
