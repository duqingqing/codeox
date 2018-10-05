package com.codeox.log.codeox.service;

import com.codeox.log.codeox.base.service.GenericManager;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.domain.Blog;
import com.codeox.log.codeox.domain.Category;
import com.codeox.log.codeox.domain.User;

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
    Result updateReaders(Long id);
    Result addBlog(User user,String title,String content);
    Result updateCategory(Category category,List<Blog> blogList);
    Result updatePreview(Blog blog);

}
