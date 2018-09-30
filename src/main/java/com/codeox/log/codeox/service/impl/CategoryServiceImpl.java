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

import javax.persistence.Column;

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

    @Override
    public Result addCayegory(String name) {
        Result result = null;
        Category category = new Category();
        category.setName(name);
        Category resultCategory = categoryRepository.save(category);
        result = resultCategory == null ? ResultUtil.error(ResultEnum.CATEGORY_ADD_ERROR) : ResultUtil.success();
        return result;
    }

    @Override
    public Category findByName(String name) {
        return this.categoryRepository.findByName(name);
    }
}
