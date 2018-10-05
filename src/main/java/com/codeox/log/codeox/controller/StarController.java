package com.codeox.log.codeox.controller;

import com.codeox.log.codeox.base.controller.GenericController;
import com.codeox.log.codeox.domain.Star;
import com.codeox.log.codeox.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @autor : duqingqing
 * @data : 2018/10/4 0004
 * @time: 11:30
 * @package: com.codeox.log.codeox.controller
 */
@Controller
@RequestMapping("/star")
public class StarController extends GenericController<Star, Long, StarService> {
    private StarService starService;

    @Autowired
    public void setStarService(StarService starService) {
        this.starService = starService;
        this.manager = this.starService;
    }
}
