package com.codeox.log.codeox.controller;

import com.codeox.log.codeox.base.controller.GenericController;
import com.codeox.log.codeox.commen.enums.ResultEnum;
import com.codeox.log.codeox.commen.password.PasswordTool;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.commen.result.ResultUtil;
import com.codeox.log.codeox.domain.User;
import com.codeox.log.codeox.service.UserService;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @autor : duqingqing
 * @data : 2018/9/17 0017
 * @time: 19:41
 * @package: com.codeox.log.codeox.controller
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController extends GenericController<User, Long, UserService> {


    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
        this.manager = this.userService;
    }

    /**
     * 拦截注册页面
     *
     * @param modelAndView
     * @return
     */
    @GetMapping("/register")
    public ModelAndView registerPage(ModelAndView modelAndView) {
        modelAndView.setViewName("user/register");
        return modelAndView;
    }

    /**
     * 拦截登入页面
     *
     * @param modelAndView
     * @return
     */

    @GetMapping("/login")
    public ModelAndView loginPage(ModelAndView modelAndView) {
        modelAndView.setViewName("user/login");
        return modelAndView;
    }

    /**
     * 用户首页
     *
     * @param modelAndView
     * @param httpSession
     * @return
     */
    @GetMapping(value = {"/", "/index"})
    public ModelAndView index(ModelAndView modelAndView, HttpSession httpSession) {
        Object object = httpSession.getAttribute("username");
        if (object == null) {
            modelAndView.setViewName("redirect:/index");
        } else {
            modelAndView.setViewName("user/index");
        }
        return modelAndView;
    }

    /**
     * 用户注册
     *
     * @param modelAndView
     * @param session
     * @param username
     * @param password
     * @param telephone
     * @return
     */
    @PostMapping("/register/action")
    public ModelAndView register(ModelAndView modelAndView, HttpSession session, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password, @RequestParam(value = "telephone") String telephone) {
        Result result = userService.addUser(username, password, telephone);
        if (result.getCode() == 0) {
            session.setAttribute("msg", "注册成功");
            try {
                //2秒跳转
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            modelAndView.setViewName("redirect:/user/login");
        } else {
            modelAndView.setViewName("user/register");
        }
        return modelAndView;
    }


    /**
     * 用户登入
     *
     * @param request
     * @param modelAndView
     * @param map
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login/action", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, ModelAndView modelAndView, Map<String, Object> map, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        //解密工具
        PasswordTool passwordTool = new PasswordTool();
        HttpSession session = request.getSession();

        //获取admin实例
        User user = userService.fingUserByUserName(username);
        if (user == null) {
            map.put("msg", ResultUtil.error(ResultEnum.USER_ACCOUNT_ERROR));
            modelAndView.setViewName("/common/error");
            return modelAndView;
        }
        String userPassword = user.getPassword();
        String decodePassword = passwordTool.decodePassword(userPassword);
        if (decodePassword.equals(password)) {
            //添加登入信息
            session.setAttribute("username", username);
            return new ModelAndView("redirect:/user/index");
        } else {
            map.put("msg", ResultUtil.error(ResultEnum.ADMIN_PASSWORD_ERROR));
            modelAndView.setViewName("/common/error");
        }
        return modelAndView;
    }


    /**
     * 用户登出
     *
     * @param modelAndView
     * @param httpSession
     * @return ModelAndView
     */
    @GetMapping("/logout")
    public ModelAndView quit(ModelAndView modelAndView, HttpSession httpSession) {
        httpSession.removeAttribute("username");
        modelAndView.setViewName("redirect:user/login");
        return modelAndView;
    }
}
