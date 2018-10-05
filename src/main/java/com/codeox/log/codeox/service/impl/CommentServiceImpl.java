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
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @autor : duqingqing
 * @data : 2018/9/26 0026
 * @time: 18:28
 * @package: com.codeox.log.codeox.service.impl
 */
@Component
public class CommentServiceImpl extends GenericManagerImpl<Comment, Long> implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
        this.dao = this.commentRepository;
    }

    /**
    * @Description: 添加评论
    * @Param: Blog blog : 评论的博客 User user: 平论用户 String content: 评论内容
    * @return: Result
    * @Date: 2018/9/30 0030
    */ 
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
