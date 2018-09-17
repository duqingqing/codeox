package com.codeox.log.codeox.commen.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @autor : duqingqing
 * @data : 2018/9/17 0017
 * @time: 17:19
 * @package: com.codeox.log.codeox.commen.enums
 */
@ToString
@Getter
@Setter
public class Result<T> {

    /** 错误代码*/
    private Integer code;

    /** 错误信息*/
    private String msg;

    /** 数据*/
    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
