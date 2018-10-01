package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.impl.GenericManagerImpl;
import com.codeox.log.codeox.commen.enums.ResultEnum;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.commen.result.ResultUtil;
import com.codeox.log.codeox.domain.Blog;
import com.codeox.log.codeox.domain.Star;
import com.codeox.log.codeox.domain.User;
import com.codeox.log.codeox.repository.StarRepository;
import com.codeox.log.codeox.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * @autor : duqingqing
 * @data : 2018/9/26 0026
 * @time: 18:30
 * @package: com.codeox.log.codeox.service.impl
 */
@Component
public class StarServiceImpl extends GenericManagerImpl<Star, Long> implements StarService {
    @Autowired
    private StarRepository starRepository;

    /**
    * @Description: 点赞函数 通过读取数据库中的Star.status（二进制）实现状态转换
    * @Param: Blog blog: 被点赞的博客 User user :点赞用户
    * @return: Result
    * @Date: 2018/9/30 0030
    */ 
    @Override
    @Transactional
    public Result pressStar(Blog blog, User user) {
        Result result = null;
        int status = 0;
        int resultNumber = 0;
        try {
            Star star = starRepository.findStarByBlogAndUser(blog, user);
            status = star.getStatus();
            if (status == 0) {
                resultNumber = starRepository.updateStar(blog, user, 1);
            } else {
                resultNumber = starRepository.updateStar(blog, user, 0);
            }
            result = resultNumber == 0 ? ResultUtil.error(ResultEnum.STAR_UPDATE_ERROR) : ResultUtil.success();
        } catch (NullPointerException nullPointer) {
            Star star = new Star();
            Star resultStar = null;
            star.setBlog(blog);
            star.setUser(user);
            star.setStatus(1);
            resultStar = starRepository.save(star);
            result = resultStar==null?ResultUtil.error(ResultEnum.STAR_UPDATE_ERROR):ResultUtil.success();
        }
        return result;
    }
}
