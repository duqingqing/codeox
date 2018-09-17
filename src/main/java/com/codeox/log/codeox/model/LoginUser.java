package com.codeox.log.codeox.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @autor : duqingqing
 * @data : 2018/9/17 0017
 * @time: 19:33
 * @package: com.codeox.log.codeox.model
 */
@Getter
@Setter
@ToString
public class LoginUser {
    private String username;
    private String password;
    private Integer rememberMe;
}
