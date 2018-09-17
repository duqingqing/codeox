package com.codeox.log.codeox.commen.enums;

/**
 * @autor : duqingqing
 * @data : 2018/9/17 0017
 * @time: 17:19
 * @package: com.codeox.log.codeox.commen.enums
 */
public enum ResultEnum {

    UNQUALIFIED_PASSWORD(-3, "    不合格的密码"),
    DUPLICATE_PHONE_NUMBERS(-2, "重复的电话号码"),
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    NO_AUTH_ERROR(1, "没有权限访问");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
