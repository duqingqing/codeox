package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.GenericGenerator;
import com.codeox.log.codeox.domain.Telephone;
import com.codeox.log.codeox.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @autor : duqingqing
 * @data : 2018/9/12 0012
 * @time: 14:41
 * @package: com.codeox.log.codeox.service.impl
 */

public class UserServiceImplTest extends GenericGenerator {

    @Autowired
    UserService userService;

    @Test
    public void addUser() {
        String username = "nimingdaoyou";
        String password = "nimingdaoyou123456@ni";
        String phoneNumber = "15093325428";
        userService.addUser(username,password,phoneNumber);
    }


}