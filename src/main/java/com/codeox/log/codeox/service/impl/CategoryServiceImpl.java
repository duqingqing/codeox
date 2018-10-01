package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.impl.GenericManagerImpl;
import com.codeox.log.codeox.commen.enums.ResultEnum;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.commen.result.ResultUtil;
import com.codeox.log.codeox.domain.Category;
import com.codeox.log.codeox.repository.CategoryRepository;
import com.codeox.log.codeox.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @autor : duqingqing
 * @data : 2018/9/30 0030
 * @time: 19:37
 * @package: com.codeox.log.codeox.service.impl
 */
@Component
public class CategoryServiceImpl extends GenericManagerImpl<Category, Long> implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * @Description: 添加博客分类
     * @Param: String name : 分类名
     * @return: Result
     * @Date: 2018/9/30 0030
     */
    @Override
    public Result addCayegory(String name) {
        Result result = null;
        Category category = new Category();
        category.setName(name);
        Category resultCategory = categoryRepository.save(category);
        result = resultCategory == null ? ResultUtil.error(ResultEnum.CATEGORY_ADD_ERROR) : ResultUtil.success();
        return result;
    }

    /**
     * @Description: 通过名字返回一个category
     * @Param: String name
     * @return: Category
     * @Date: 2018/9/30 0030
     */
    @Override
    public Category findByName(String name) {
        return this.categoryRepository.findByName(name);
    }
}
