package com.codeox.log.codeox.repository;

import com.codeox.log.codeox.base.dao.GenericDao;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.domain.Blog;
import com.codeox.log.codeox.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @autor : duqingqing
 * @data : 2018/9/26 0026
 * @time: 18:20
 * @package: com.codeox.log.codeox.repository
 */
@Transactional
public interface BlogRepository extends GenericDao<Blog,Long> {

    @Query(value = "select blog from Blog blog where blog.title like %:title%")
    List<Blog> findBlogsByTitleLike(@Param(value = "title")String title);

    @Query(value = "select blog from Blog blog where blog.author=?1")
    List<Blog> findBlogsByAuthor(User author);

    @Modifying
    @Query(value = "update Blog b set b.title =:title where b =:blog ")
    int updateTitle(@Param(value = "blog") Blog blog,  @Param(value = "title")String title);

    @Modifying
    @Query(value = "update Blog b set b.content =:content where b =:blog ")
    int updateContent(@Param(value = "blog") Blog blog, @Param(value = "content")String content);

    @Modifying
    @Query(value = "update Blog b set b.readers = b.readers+1 where b=:blog")
    int updateReaders(@Param(value = "blog") Blog blog);






}
