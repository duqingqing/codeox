package com.codeox.log.codeox.commen.enums;

/**
 * @autor : duqingqing
 * @data : 2018/9/17 0017
 * @time: 17:19
 * @package: com.codeox.log.codeox.commen.enums
 */
public enum ResultEnum {
    BLOG_UPDATE_CATEGORY_ERROR(-9,"批量修改博客类别错误"),
    CATEGORY_ADD_ERROR(-8,"添加类别失败"),
    STAR_UPDATE_ERROR(-7,"点赞失败"),
    COMMENT_ADD_ERROR(-6,"评论添加失败"),
    BLOG_ADD_ERROR(-5, "添加博客失败"),
    BLOG_UPDATE_ERROR(-4, "博客更新错误"),
    UNQUALIFIED_PASSWORD(-3, "    不合格的密码"),
    DUPLICATE_PHONE_NUMBERS(-2, "重复的电话号码"),
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    NO_ACCESS_ERROR(1, "没有权限访问");

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
