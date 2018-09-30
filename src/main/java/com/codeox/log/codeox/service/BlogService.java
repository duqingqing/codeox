package com.codeox.log.codeox.service;

import com.codeox.log.codeox.base.service.GenericManager;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.domain.Blog;
import com.codeox.log.codeox.domain.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @autor : duqingqing
 * @data : 2018/9/26 0026
 * @time: 18:25
 * @package: com.codeox.log.codeox.service
 */

public interface BlogService extends GenericManager<Blog,Long> {
    List<Blog> findBlogsByTitleLike(String title);
    List<Blog> findBlogsByAuthor(User author);
    Result updateTitle(Blog blog, String title);
    Result updateContent(Blog blog, String content);
    Result updateReaders(Blog blog);
    Result addBlog(User user,String title,String content);

}
