package com.codeox.log.codeox.controller;

import com.codeox.log.codeox.commen.password.PasswordTool;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.domain.User;
import com.codeox.log.codeox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody Map<String, String> registerUser) {
        Result result = userService.addUser(registerUser.get("username"), registerUser.get("password"), registerUser.get("telephone"));
        return result;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, HttpSession httpSession, String username, String password){
        try {
            User user = userService.fingUserByUserName(username);
            String encodeUserPasswprd = user.getPassword();
            PasswordTool passwordTool = new PasswordTool();
            String decodeUserpassword = passwordTool.decodePassword(encodeUserPasswprd);
      if(!password.equals(decodeUserpassword)){
            modelAndView.addObject("error", "密码不正确");
            modelAndView.setViewName("login");
        }else{
            httpSession.setAttribute("user", username);
            modelAndView.setViewName("admin/admin");
        }
        }catch (NullPointerException nullPointerException){
            modelAndView.addObject("error", "用户名不存在");
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }
    @GetMapping("/quit")
    public ModelAndView quit(ModelAndView modelAndView, HttpSession httpSession){
        httpSession.removeAttribute("user");
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
