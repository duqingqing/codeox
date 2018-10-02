package com.codeox.log.codeox.controller;


import com.codeox.log.codeox.commen.password.PasswordTool;
import com.codeox.log.codeox.domain.Admin;
import com.codeox.log.codeox.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Slf4j
public class AdminControlller {
    @Autowired
    private AdminService adminService;

    /**
     * @Description: 管理员首页, 通过session判断登入状态
     * @Param: modelAndView
     * @ParamhttpSession
     * @return:ModelAndView
     * @Date: 2018/10/2 0002
     */
    @GetMapping({"/", "/index", "/login"})
    public String index(ModelAndView modelAndView, HttpSession httpSession) {
        Object object = httpSession.getAttribute("name");
        String result = "";
        if (object == null) {
            result = "/admin/login";
        } else {
            result = "/admin/index";
        }
        return result;
    }

//    @GetMapping("/login")
//    public String login() {
//        return "/admin/login";
//    }

    /**
     * @Description: 管理员登入
     * @Param:
     * @return:
     * @Date: 2018/10/2 0002
     */
    @RequestMapping (value = "/login/action",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request) {
        //解密工具
        PasswordTool passwordTool = new PasswordTool();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/login");
        HttpSession session = request.getSession();
        //从表单获取名字和密码
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        log.info("【登入名】" + name);
        log.info("【密码】" + password);

        //获取admin实例
        Admin admin = adminService.findByName(name);
        String adminPassword = admin.getPassword();
        String decodePassword = passwordTool.decodePassword(adminPassword);
        log.info("【数据库密码】" + decodePassword);
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

