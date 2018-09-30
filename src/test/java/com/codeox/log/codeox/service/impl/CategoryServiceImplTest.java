package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.GenericGenerator;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.domain.Category;
import com.codeox.log.codeox.service.CategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @autor : duqingqing
 * @data : 2018/9/30 0030
 * @time: 19:40
 * @package: com.codeox.log.codeox.service.impl
 */

public class CategoryServiceImplTest extends GenericGenerator {
    @Autowired
    private CategoryService categoryService;

    /**
    * @Description: 测试添加博客
    * @Param:
    * @return: 
    * @Date: 2018/9/30 0030
    */ 
    @Test
    public void testAddCategory(){
        Result result = categoryService.addCayegory("Spring");
        System.out.println(result);
    }
    @Test
    public void testFinfByName(){
        Category category = categoryService.findByName("python");
        System.out.println(category);
    }
}
