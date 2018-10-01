package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.impl.GenericManagerImpl;
import com.codeox.log.codeox.commen.enums.ResultEnum;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.commen.result.ResultUtil;
import com.codeox.log.codeox.domain.Blog;
import com.codeox.log.codeox.domain.Category;
import com.codeox.log.codeox.domain.User;
import com.codeox.log.codeox.repository.BlogRepository;
import com.codeox.log.codeox.service.BlogService;
import com.codeox.log.codeox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @autor : duqingqing
 * @data : 2018/9/26 0026
 * @time: 18:26
 * @package: com.codeox.log.codeox.service.impl
 */
@Component
@Transactional
public class BlogServiceImpl extends GenericManagerImpl<Blog, Long> implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserService userService;

    /**
     * @Description: 通过 title 模糊查寻 blog
     * @Param: String title
     * @return: List<Blog>
     * @Date: 2018/9/30 0030
     */
    @Override
    public List<Blog> findBlogsByTitleLike(String title) {
        return blogRepository.findBlogsByTitleLike(title);
    }

    /**
     * @Description: 通过author 查找 博客
     * @Param:User author
     * @return: List<blog>
     * @Date: 2018/9/30 0030
     */
    @Override
    public List<Blog> findBlogsByAuthor(User author) {
        return blogRepository.findBlogsByAuthor(author);
    }

    /**
     * @Description: 修改博客标题
     * @Param: Blog blog, String title : 新的标题
     * @return: Result
     * @Date: 2018/9/30 0030
     */
    @Override
    public Result updateTitle(Blog blog, String title) {
        Result result;
        int status = blogRepository.updateTitle(blog, title);
        result = status > 0 ? ResultUtil.success() : ResultUtil.error(ResultEnum.BLOG_UPDATE_ERROR);
        return result;
    }

    /**
     * @Description: 修改博客内容
     * @Param: Blog blog, String content : 新的内容
     * @return: Result
     * @Date: 2018/9/30 0030
     */
    @Override
    public Result updateContent(Blog blog, String content) {
        Result result;
        int status = blogRepository.updateContent(blog, content);
        result = status > 0 ? ResultUtil.success() : ResultUtil.error(ResultEnum.BLOG_UPDATE_ERROR);
        return result;
    }

    /**
     * @Description: 添加博客阅读数量
     * @Param: Blog blog
     * @return: Result
     * @Date: 2018/9/30 0030
     */
    @Override
    public Result updateReaders(Blog blog) {
        Result result;
        int status = blogRepository.updateReaders(blog);
        result = status > 0 ? ResultUtil.success() : ResultUtil.error(ResultEnum.BLOG_UPDATE_ERROR);
        return result;
    }

    /**
     * @Description: 添加博客
     * @Param: User user, String title, String content
     * @return: Result
     * @Date: 2018/9/30 0030
     */
    @Override
    public Result addBlog(User user, String title, String content) {
        Result result = null;
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setAuthor(user);
        Blog resultBlog = blogRepository.save(blog);
        result = resultBlog != null ? ResultUtil.success() : ResultUtil.error(ResultEnum.BLOG_ADD_ERROR);
        return result;
    }

    /**
     * @Description: 批量修改博客的分类
     * @Param: category : 博客的分类 blogList : 博客数组
     * @return: Result
     * @Date: 2018/9/30 0030
     */
    @Override
    public Result updateCategory(Category category, List<Blog> blogList) {
        Result result = null;
        int resultNumberSum = 0;
        int length = blogList.size();
        for (Blog blog : blogList) {
            int resultNumber = blogRepository.updateCategory(category, blog.getId());
            resultNumberSum += resultNumber;
        }
        result = resultNumberSum >= length ? ResultUtil.success() : ResultUtil.error(ResultEnum.BLOG_UPDATE_CATEGORY_ERROR);
        return result;
    }
}

