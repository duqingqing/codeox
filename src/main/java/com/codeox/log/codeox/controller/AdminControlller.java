package com.codeox.log.codeox.controller;


import com.codeox.log.codeox.commen.password.PasswordTool;
import com.codeox.log.codeox.domain.Admin;
import com.codeox.log.codeox.domain.User;
import com.codeox.log.codeox.service.AdminService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @autor : duqingqing
 * @data : 2018/9/17 0017
 * @time: 22:03
 * @package: com.codeox.log.codeox.controller
 */

@Controller
@RequestMapping("/admin")
public class AdminControlller {
    @Autowired
    private AdminService adminService;

    /**
     * @Description: 管理员首页,通过session判断登入状态
     * @Param: modelAndView
     * @ParamhttpSession
     * @return:ModelAndView
     * @Date: 2018/10/2 0002
     */
    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView, HttpSession httpSession) {
        Object object = httpSession.getAttribute("name");
        if (object == null) {
            modelAndView.setViewName("admin/login");
        } else {
            modelAndView.setViewName("admin/index");
        }
        return modelAndView;
    }

    /**
     * @Description: 管理员登入
     * @Param:
     * @return:
     * @Date: 2018/10/2 0002
     */
    @PostMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request) {
        //解密工具
        PasswordTool passwordTool = new PasswordTool();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/login");
        HttpSession session = request.getSession();
        //从表单获取名字和密码
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        //获取admin实例
        Admin admin = adminService.findByName(name);
        String adminPassword = admin.getPassword();
        String decodePassword = passwordTool.decodePassword(adminPassword);
        if (decodePassword.equals(password)) {
            //添加登入信息
            session.setAttribute("name", name);
            session.setAttribute("entryNumber", admin.getEntryNumber() + 1);
            session.setAttribute("lastEntry", admin.getLastEntry());
            adminService.updateLastEntry(admin);
            modelAndView.setViewName("admin/index");
        }
        return modelAndView;
    }


}

