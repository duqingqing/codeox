package com.codeox.log.codeox.commen.spider;


import org.apache.commons.lang3.StringUtils;

public class JudgeStringFormat {
    //过滤表情
    public static String filterEmoji(String source, String slipStr) {
        if (StringUtils.isNotBlank(source)) {
            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", slipStr);
        } else {
            return source;
        }
    }
}
