package com.codeox.log.codeox.Interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户拦截，通过判断session，拦截用户
 *
 * @autor : duqingqing
 * @data : 2018/10/3 0003
 * @time: 22:35
 * @package: com.codeox.log.codeox.controller
 */

public class UserInterceptor extends HandlerInterceptorAdapter {

    //在控制器执行前调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {

            return true;  //通过拦截器，继续执行请求
        } else {
            response.sendRedirect(request.getContextPath()+"/user/login");
            return false;  //没有通过拦截器，返回登录页面
        }
    }

    //在后端控制器执行后调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        super.postHandle(request, response, handler, modelAndView);
    }

    //整个请求执行完成后调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        super.afterCompletion(request, response, handler, ex);
    }
}


