package com.codeox.log.codeox.service;

import com.codeox.log.codeox.base.service.GenericManager;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.domain.Telephone;
import com.codeox.log.codeox.domain.User;

/**
 * @autor : duqingqing
 * @data : 2018/9/12 0012
 * @time: 9:39
 * @package: com.codeox.log.codeox.service
 */

public interface UserService extends GenericManager<User,Long> {
     Result addUser(String username, String password, String telePhoneNumber);
     User fingUserByUserName(String username);
     Result changeTelephone(User user,String  newTelephoneNumber);



}
