package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.GenericGenerator;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.domain.Blog;
import com.codeox.log.codeox.domain.User;
import com.codeox.log.codeox.service.BlogService;
import com.codeox.log.codeox.service.CommentService;
import com.codeox.log.codeox.service.StarService;
import com.codeox.log.codeox.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @autor : duqingqing
 * @data : 2018/9/26 0026
 * @time: 18:40
 * @package: com.codeox.log.codeox.service.impl
 */

public class StarServiceImplTest extends GenericGenerator {
    @Autowired
    private StarService starService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    @Autowired
    BlogService blogService;

    @Test
    public void testAddStar(){
        Result result =null;
        User author = userService.fingUserByUserName("匿名道友");
        Blog blog = blogService.findBlogsByTitleLike("python 框架Flask学习笔记之session").get(0);
        result = starService.pressStar(blog,author);
        System.out.println(result);
    }
}
