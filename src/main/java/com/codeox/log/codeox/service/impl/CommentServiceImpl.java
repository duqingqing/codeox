package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.impl.GenericManagerImpl;
import com.codeox.log.codeox.domain.Comment;
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
public class CommentServiceImpl extends GenericManagerImpl<Comment,Long> implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
}
