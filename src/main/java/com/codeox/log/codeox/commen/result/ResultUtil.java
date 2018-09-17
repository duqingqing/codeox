package com.codeox.log.codeox.commen.result;

import com.codeox.log.codeox.commen.enums.ResultEnum;

/**
 * @autor : duqingqing
 * @data : 2018/9/17 0017
 * @time: 17:19
 * @package: com.codeox.log.codeox.commen.enums
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result(ResultEnum.SUCCESS.getCode(),
                ResultEnum.SUCCESS.getMsg(),
                object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        return new Result(code, msg, null);
    }

    public static Result error(ResultEnum resultEnum) {
        return new Result(resultEnum.getCode(), resultEnum.getMsg(), null);
    }

}
