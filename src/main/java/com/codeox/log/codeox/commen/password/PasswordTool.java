package com.codeox.log.codeox.commen.password;

import com.codeox.log.codeox.commen.encode.EncodeAndDecode;
import com.codeox.log.codeox.commen.enums.ResultEnum;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.commen.result.ResultUtil;

import java.security.MessageDigest;

/**
 * @autor : duqingqing
 * @data : 2018/9/12 0012
 * @time: 16:33
 * @package: com.codeox.log.codeox.comment.password
 */
public class PasswordTool {
    //加密工具
    private EncodeAndDecode encodeAndDecode;

    /**
     * 判断长度
     * @param password
     * @return
     */
    public boolean verifyingLength(String password) {
        if (password.length() < 50 && password.length() > 6) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 加密
     *
     * @param password
     * @return
     */
    public String encodePassword(String password) {
            String encodePassword = encodeAndDecode.encrypt(password);
            return encodePassword;
    }

    /**
     * 解密
     *
     * @param encodePassword
     * @return
     */
    public String decodePassword(String encodePassword) {
        String decodePassword = encodeAndDecode.decrypt(encodePassword);
        return decodePassword;
    }


}
