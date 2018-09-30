package com.codeox.log.codeox.service.taskService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @autor : duqingqing
 * @data : 2018/9/27 0027
 * @time: 19:30
 * @package: com.codeox.log.codeox.service.taskService
 */
@Component
@Slf4j
public class AsyncTestService {

    @Async
    public void doAsync(){
        //do async method
    }

}
