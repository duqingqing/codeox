package com.codeox.log.codeox.controller;

import com.codeox.log.codeox.base.controller.GenericController;
import com.codeox.log.codeox.domain.Comment;
import com.codeox.log.codeox.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @autor : duqingqing
 * @data : 2018/10/4 0004
 * @time: 11:28
 * @package: com.codeox.log.codeox.controller
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends GenericController<Comment, Long, CommentService> {

    private CommentService commentService;

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
        this.manager = this.commentService;
    }
}
