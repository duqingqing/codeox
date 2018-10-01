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

    /**
    * @Description: 添加用户
    * @Param: String username, String password, String telePhoneNumber
    * @return: Result
    * @Date: 2018/9/30 0030
    */ 
    @Override
    public Result addUser(String username, String password, String telePhoneNumber) {
        PasswordTool passwordTool = new PasswordTool();
        if (passwordTool.verifyingLength(password)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordTool.encodePassword(password));
            Telephone telePhone = new Telephone();
            telePhone.setTelePhoneNumber(telePhoneNumber);
            telePhone.setUser(user);
            telePhoneRepository.save(telePhone);
            userRepository.save(user);
            return ResultUtil.success();
        } else {
            return ResultUtil.error(ResultEnum.UNQUALIFIED_PASSWORD);
        }
    }

    /**
    * @Description: 通过名字查找用户
    * @Param: String username
    * @return: User
    * @Date: 2018/9/30 0030
    */ 
    @Override
    public User fingUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }
    /**
    * @Description: 用户修改电话号码，通过telephone.delete 来存储电话号码的状态
    * @Param: User user, String newTelephoneNumber : 新的电话号码
    * @return: Result
    * @Date: 2018/9/30 0030
    */
    @Override
    @Transactional
    public Result changeTelephone(User user, String newTelephoneNumber) {
        String oldTelephone = telePhoneRepository.findSurvivalTelephone(user).getTelePhoneNumber();
        if (oldTelephone.equals(newTelephoneNumber)) {
            return ResultUtil.error(ResultEnum.DUPLICATE_PHONE_NUMBERS);
        } else {
            telePhoneRepository.changeSurvivalTelephoneToDeath(user);
            Telephone newTelephone = new Telephone();
            newTelephone.setTelePhoneNumber(newTelephoneNumber);
            newTelephone.setUser(user);
            telePhoneRepository.save(newTelephone);
            return ResultUtil.success();
        }
    }
}
