package com.codeox.log.codeox.service;

import com.codeox.log.codeox.base.service.GenericManager;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.domain.Blog;
import com.codeox.log.codeox.domain.Star;
import com.codeox.log.codeox.domain.User;
import com.codeox.log.codeox.repository.StarRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @autor : duqingqing
 * @data : 2018/9/26 0026
 * @time: 18:30
 * @package: com.codeox.log.codeox.service
 */

public interface StarService extends GenericManager<Star,Long> {
    Result pressStar(Blog blog,User user);
}
