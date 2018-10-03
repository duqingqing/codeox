package com.codeox.log.codeox.controller;

import com.codeox.log.codeox.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @autor : duqingqing
 * @data : 2018/10/2 0002
 * @time: 18:41
 * @package: com.codeox.log.codeox.controller
 */
@Controller
@RequestMapping(value = "/ueditor")
public class UEditorController {


    @GetMapping("/")
    private ModelAndView editPage(ModelAndView modelAndView) {
        modelAndView.setViewName("ueditor/ueditor");
        return modelAndView;
    }

    @RequestMapping(value = "/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
