package com.codeox.log.codeox.service;

import com.codeox.log.codeox.base.service.GenericManager;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.domain.Category;

/**
 * @autor : duqingqing
 * @data : 2018/9/30 0030
 * @time: 19:37
 * @package: com.codeox.log.codeox.service.taskService
 */
public interface CategoryService extends GenericManager<Category,Long> {
    Result addCayegory(String name);
    Category findByName(String name);
}
