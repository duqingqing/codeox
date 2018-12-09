package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.GenericGenerator;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.commen.spider.GetDocument;
import com.codeox.log.codeox.domain.Blog;
import com.codeox.log.codeox.domain.Category;
import com.codeox.log.codeox.domain.User;
import com.codeox.log.codeox.service.BlogService;
import com.codeox.log.codeox.service.CategoryService;
import com.codeox.log.codeox.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.lang.annotation.Documented;
import java.util.List;

/**
 * @autor : duqingqing
 * @data : 2018/9/26 0026
 * @time: 18:19
 * @package: com.codeox.log.codeox.service.impl
 */
@Slf4j
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

    @Test
    @Transactional
    public void testFindById() {
        Blog blog = blogService.findById((long)1);
        System.out.println(blog.getTitle());
    }
    @Test
    public void addBlogTestBySpider(){
        Document document = null;
        Document document1 = null;
        String goal = "https://blog.csdn.net/nav/arch";
        document = GetDocument.connect(goal);
        for(int i=1;i<300;i++){
            Elements titleElement = document.select("#feedlist_id > li:nth-child("+i+") > div > div.title > h2 > a");
            String author = document.select("#feedlist_id > li:nth-child("+i+") > div > dl > dd.name > a").text();
            String title  = titleElement.text();
            String title_href = titleElement.attr("href");

            System.out.println(title);
            System.out.println(author);
            System.out.println(title_href);
            try {
                document1 = GetDocument.connect(title_href);
                String content = document1.select("#article_content").html();
                Result result1 = userService.addUser(author, "12345678", "1379876080" + i);
                User author2= userService.fingUserByUserName(author);
                Result result2 = blogService.addBlog(author2, title, content);
                log.info( result1.toString()+"------"+result2.toString());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("--------------------------------------------------");
            }catch (Exception e){
                continue;
            }
        }

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
    @Test
    public void testUpdatePreview(){
        List<Blog> blogList = blogService.findAll();
        for(Blog blog : blogList){
            Result result = blogService.updatePreview(blog);
            System.out.println(result);
        }
    }
}
