package com.codeox.log.codeox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @autor : duqingqing
 * @data : 2018/10/3 0003
 * @time: 15:31
 * @package: com.codeox.log.codeox.controller
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {
    @GetMapping(value = {"/","/home","index"})
    public String index() {
        return "index";
    }

    @GetMapping(value = "/contant")
    public String contant(){
        return "contant";
    }
}
