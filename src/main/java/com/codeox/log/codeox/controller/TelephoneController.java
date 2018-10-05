package com.codeox.log.codeox.controller;

import com.codeox.log.codeox.base.controller.GenericController;
import com.codeox.log.codeox.base.service.impl.GenericManagerImpl;
import com.codeox.log.codeox.domain.Telephone;
import com.codeox.log.codeox.service.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @autor : duqingqing
 * @data : 2018/10/4 0004
 * @time: 11:32
 * @package: com.codeox.log.codeox.controller
 */
@Controller
@RequestMapping("/telephone")
public class TelephoneController extends GenericController<Telephone, Long, TelephoneService> {
    private TelephoneService telephoneService;

    @Autowired
    public void setTelephoneService(TelephoneService telephoneService) {
        this.telephoneService = telephoneService;
        this.manager = this.telephoneService;
    }
}
