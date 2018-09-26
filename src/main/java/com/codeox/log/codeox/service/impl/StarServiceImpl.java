package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.impl.GenericManagerImpl;
import com.codeox.log.codeox.domain.Star;
import com.codeox.log.codeox.repository.StarRepository;
import com.codeox.log.codeox.service.StarService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @autor : duqingqing
 * @data : 2018/9/26 0026
 * @time: 18:30
 * @package: com.codeox.log.codeox.service.impl
 */
@Component
public class StarServiceImpl extends GenericManagerImpl<Star,Long> implements StarService {
    @Autowired
    private StarRepository starRepository;
}
