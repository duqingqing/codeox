package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.GenericGenerator;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.domain.User;
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
        String username = "xiaoming";
        String password = "123";
        String phoneNumber = "13803584041";
        Result result = userService.addUser(username,password,phoneNumber);
        System.out.println(result);
    }
    @Test
    public void testFindByUserName(){
        try {
            User user = userService.fingUserByUserName("asdf");
            user.toString();
        }catch (NullPointerException nullPoint){
            System.out.println("你没有注册");
        }

    }
}