package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.impl.GenericManagerImpl;
import com.codeox.log.codeox.commen.enums.ResultEnum;
import com.codeox.log.codeox.commen.password.PasswordTool;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.commen.result.ResultUtil;
import com.codeox.log.codeox.domain.Telephone;
import com.codeox.log.codeox.domain.User;
import com.codeox.log.codeox.repository.TelePhoneRepository;
import com.codeox.log.codeox.repository.UserRepository;
import com.codeox.log.codeox.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.transaction.Transactional;

/**
 * @autor : duqingqing
 * @data : 2018/9/12 0012
 * @time: 9:37
 * @package: com.codeox.log.codeox.service
 */
@Component
@Transactional
public class UserServiceImpl extends GenericManagerImpl<User, Long> implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TelePhoneRepository telePhoneRepository;

    @Override
    public Result addUser(String username, String password, String telePhoneNumber) {
        User user = new User();
        user.setUsername(username);
        PasswordTool passwordTool = new PasswordTool();
        if(passwordTool.verifyingLength(password)) {
            user.setPassword(passwordTool.encodePassword(password));
            Telephone telePhone = new Telephone();
            telePhone.setTelePhoneNumber(telePhoneNumber);
            telePhone.setUser(user);
            telePhoneRepository.save(telePhone);
            userRepository.save(user);
            return ResultUtil.success();
        }else{
            return ResultUtil.error(ResultEnum.UNQUALIFIED_PASSWORD);
        }
    }

    @Override
    public void changeTelePhone() {

    }

}
