package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.impl.GenericManagerImpl;
import com.codeox.log.codeox.domain.Blog;
import com.codeox.log.codeox.repository.BlogRepository;
import com.codeox.log.codeox.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @autor : duqingqing
 * @data : 2018/9/26 0026
 * @time: 18:26
 * @package: com.codeox.log.codeox.service.impl
 */
@Component
public class BlogServiceImpl extends GenericManagerImpl<Blog,Long> implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
}
