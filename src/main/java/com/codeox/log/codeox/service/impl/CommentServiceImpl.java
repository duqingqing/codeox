package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.impl.GenericManagerImpl;
import com.codeox.log.codeox.commen.enums.ResultEnum;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.commen.result.ResultUtil;
import com.codeox.log.codeox.domain.Blog;
import com.codeox.log.codeox.domain.Comment;
import com.codeox.log.codeox.domain.User;
import com.codeox.log.codeox.repository.CommentRepository;
import com.codeox.log.codeox.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @autor : duqingqing
 * @data : 2018/9/26 0026
 * @time: 18:28
 * @package: com.codeox.log.codeox.service.impl
 */
@Component
public class CommentServiceImpl extends GenericManagerImpl<Comment, Long> implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Result addComment(Blog blog, User user, String content) {
        Result result = null;
        Comment comment = new Comment();
        comment.setBlog(blog);
        comment.setUser(user);
        comment.setContent(content);
        Comment resultComment = commentRepository.save(comment);
        result = resultComment == null ? ResultUtil.error(ResultEnum.COMMENT_ADD_ERROR) : ResultUtil.success();
        return result;
    }
}
