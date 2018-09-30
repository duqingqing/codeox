package com.codeox.log.codeox.service;

import com.codeox.log.codeox.base.service.GenericManager;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.domain.Blog;
import com.codeox.log.codeox.domain.Comment;
import com.codeox.log.codeox.domain.User;

/**
 * @autor : duqingqing
 * @data : 2018/9/26 0026
 * @time: 18:28
 * @package: com.codeox.log.codeox.service
 */
public interface CommentService extends GenericManager<Comment,Long> {
    Result addComment(Blog blog, User user,String content);
}
