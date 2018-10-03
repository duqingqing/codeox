package com.codeox.log.codeox.controller;


import com.codeox.log.codeox.commen.enums.ResultEnum;
import com.codeox.log.codeox.commen.password.PasswordTool;
import com.codeox.log.codeox.commen.result.ResultUtil;
import com.codeox.log.codeox.domain.Admin;
import com.codeox.log.codeox.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


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
    public ModelAndView index(ModelAndView modelAndView, HttpSession httpSession) {
        Object object = httpSession.getAttribute("name");
        String result;
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
    @RequestMapping(value = "/login/action", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, ModelAndView modelAndView, Map<String, Object> map, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        //解密工具
        PasswordTool passwordTool = new PasswordTool();
        HttpSession session = request.getSession();

        //获取admin实例
        Admin admin = adminService.findByName(username);
        if (admin == null) {
            map.put("msg", ResultUtil.error(ResultEnum.ADMIN_ACCOUNT_ERROR));
            modelAndView.setViewName("/common/error");
            return modelAndView;
        }
        String adminPassword = admin.getPassword();
        String decodePassword = passwordTool.decodePassword(adminPassword);
        if (decodePassword.equals(password)) {
            //添加登入信息
            session.setAttribute("name", username);
            session.setAttribute("entryNumber", admin.getEntryNumber() + 1);
            session.setAttribute("lastEntry", admin.getLastEntry());
            adminService.updateLastEntry(admin);
            modelAndView.setViewName("/admin/index");
        } else {
            map.put("msg", ResultUtil.error(ResultEnum.ADMIN_PASSWORD_ERROR));
            modelAndView.setViewName("/common/error");
        }
        return modelAndView;
    }


}

