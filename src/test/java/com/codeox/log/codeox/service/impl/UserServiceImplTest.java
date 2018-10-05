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
        String username = "番茄酱";
        String password = "12345678";
        String phoneNumber = "15093325489";
        Result result = userService.addUser(username,password,phoneNumber);
        String username2 = "匿名道友";
        String password2 = "12345678";
        String phoneNumber2 = "15093325427";
        Result result2 = userService.addUser(username2,password2,phoneNumber2);
        System.out.println(result);
        System.out.println(result2);
    }
    @Test
    public void testFindByUserName(){
        try {
            User user = userService.fingUserByUserName("沐 晴");
            user.toString();
        }catch (NullPointerException nullPoint){
            System.out.println("你没有注册");
        }
    }
}