package com.codeox.log.codeox.commen.telephone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @autor : duqingqing
 * @data : 2018/9/12 0012
 * @time: 15:18
 * @package: com.codeox.log.codeox.Comment.telephone
 */
public class RegTelephone {
    /**
     * 手机号正则表达式
     */
    private static final String PHONE_NUM_VALIDATOR_REGULAREXP = "^[1][3,4,5,6,7,8,9][0-9]{9}$";
    /**
     * 带区号手机号正则表达式
     */
    private static final String AREA_CODE_NUM_VALIDATOR_REGULAREXP = "^[0][1-9]{2,3}-[0-9]{5,10}$";
    /**
     * 不带区号手机号正则表达式
     */
    private static final String NONE_AREA_CODE_NUM_VALIDATOR_REGULAREXP = "^[1-9]{1}[0-9]{5,8}$";

    /**
     * 手机号验证
     */
    public static boolean isMobile(final String str) {
        Matcher m = Pattern.compile(PHONE_NUM_VALIDATOR_REGULAREXP).matcher(str);
        return m.matches();
    }

    /**
     * 电话号码验证
     */
    public static boolean isPhone(final String str) {
        Matcher m;
        boolean isRight;

        if (str.length() > 9) {
            m = Pattern.compile(AREA_CODE_NUM_VALIDATOR_REGULAREXP).matcher(str);
            isRight = m.matches();
        } else {
            m = Pattern.compile(NONE_AREA_CODE_NUM_VALIDATOR_REGULAREXP).matcher(str);
            isRight = m.matches();
        }
        return isRight;
    }

    public static void main(String[] args) {
        System.out.println(isMobile("15093325427"));
    }
}
