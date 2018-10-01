package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.GenericGenerator;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.domain.Blog;
import com.codeox.log.codeox.domain.Category;
import com.codeox.log.codeox.domain.User;
import com.codeox.log.codeox.service.BlogService;
import com.codeox.log.codeox.service.CategoryService;
import com.codeox.log.codeox.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @autor : duqingqing
 * @data : 2018/9/26 0026
 * @time: 18:19
 * @package: com.codeox.log.codeox.service.impl
 */
public class BlogServiceImplTest extends GenericGenerator {

    @Autowired
    BlogService blogService;
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;

    /**
     * @Description: 测试添加博客
     * @Param: null
     * @return: null
     * @Date: 2018/9/26 0026
     */
    /**
     * @Description: 单元测试，测试添加博客
     * @Param:
     * @return:
     * @Date: 2018/9/30 0030
     */
    @Test
    public void addBlogTest() {
        User author = userService.fingUserByUserName("匿名道友");
        String title = "Spring Web MVC";
        String content = "Spring Web MVC 是包含在 Spring 框架中的 Web 框架，建立于 Servlet API 之上。";
        Result result = blogService.addBlog(author, title, content);
        System.out.println(result);
    }

    /**
     * @Description: 测试通过标题模糊查询博客
     * @Param:
     * @return:
     * @Date: 2018/9/30 0030
     */
    @Test
    public void testFindByTitle() {
        List<Blog> blogList = blogService.findBlogsByTitleLike("python 框架Flask学习笔记之session");
        System.out.println("匹配的数量" + blogList.size());
    }

    /**
     * @Description: 测试批量修改博客分类
     * @Param:
     * @return:
     * @Date: 2018/9/30 0030
     */
    @Test
    public void testUpdateCategory() {
        Category category = categoryService.findByName("Spring");
        List<Blog> blogList = blogService.findBlogsByTitleLike("Spring");
        Result result = blogService.updateCategory(category, blogList);
        System.out.println(result);
    }
}
