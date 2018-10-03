package com.codeox.log.codeox.config;

import com.codeox.log.codeox.Interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpSession;

/**
 * @autor : duqingqing
 * @data : 2018/10/3 0003
 * @time: 22:50
 * @package: com.codeox.log.codeox.config
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private HttpSession httpSession;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //这里可以添加多个拦截器
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/ueditor");
    }
}


