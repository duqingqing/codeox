package com.codeox.log.codeox.init;

import com.codeox.log.codeox.base.service.GenericGenerator;
import com.codeox.log.codeox.commen.password.PasswordTool;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.domain.Admin;
import com.codeox.log.codeox.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Auther: duqingqing
 * @Date: 18-11-13 20:24
 * @Description:
 */
@Component
@Order(value=1)
@Slf4j
public class InitRunner extends GenericGenerator implements CommandLineRunner {
    @Autowired
    private AdminService adminService;

    @Value("${codeox.admin.password}")
    private String password;
    @Value("${codeox.admin.name}")
    private String adminName;


    @Override
    public void run(String... args) throws Exception {
        Admin admin = new Admin();
        PasswordTool passwordTool = new PasswordTool();
        String encodePassword =  passwordTool.encodePassword(password);
        Result result =  adminService.addAdmin(adminName,encodePassword);
        log.info("init web service result = "+result);
    }
}
