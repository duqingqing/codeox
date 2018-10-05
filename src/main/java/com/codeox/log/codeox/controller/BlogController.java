package com.codeox.log.codeox.controller;

import com.codeox.log.codeox.base.controller.GenericController;
import com.codeox.log.codeox.domain.Blog;
import com.codeox.log.codeox.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @autor : duqingqing
 * @data : 2018/10/4 0004
 * @time: 11:25
 * @package: com.codeox.log.codeox.controller
 */
@RestController
@RequestMapping("/blog")
public class BlogController extends GenericController<Blog, Long, BlogService> {
    private BlogService blogService;

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
        this.manager = this.blogService;
    }

    @GetMapping("/list")
    public List<Blog> getList(){
        List<Blog> blogList = blogService.findAll();
        return blogList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Blog getOne(@PathVariable Long id,HttpServletResponse response) {
        blogService.updateReaders(id);
        return this.manager.findById(id);
    }

}
