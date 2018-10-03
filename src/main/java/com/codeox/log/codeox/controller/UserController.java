package com.codeox.log.codeox.controller;

import com.codeox.log.codeox.commen.password.PasswordTool;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.domain.User;
import com.codeox.log.codeox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> registerUser) {
        Result result = userService.addUser(registerUser.get("username"), registerUser.get("password"), registerUser.get("telephone"));
        if (result.getCode() == 0) {
            return "hellow";
        } else {
            return "register";
        }
    }

    @GetMapping("/registerPage")
    public String registerPage() {
        return "/register";
    }

    @PostMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, HttpSession httpSession, String username, String password) {
        try {
            User user = userService.fingUserByUserName(username);
            String encodeUserPasswprd = user.getPassword();
            PasswordTool passwordTool = new PasswordTool();
            String decodeUserpassword = passwordTool.decodePassword(encodeUserPasswprd);
            if (!password.equals(decodeUserpassword)) {
                modelAndView.addObject("error", "密码不正确");
                modelAndView.setViewName("login");
            } else {
                httpSession.setAttribute("user", username);
                modelAndView.setViewName("/index");
            }
        } catch (NullPointerException nullPointerException) {
            modelAndView.addObject("error", "用户名不存在");
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }


    @GetMapping("/quit")
    public ModelAndView quit(ModelAndView modelAndView, HttpSession httpSession) {
        httpSession.removeAttribute("user");
        modelAndView.setViewName("login");
        return modelAndView;
    }
}