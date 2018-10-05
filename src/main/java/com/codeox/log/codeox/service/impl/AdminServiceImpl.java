package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.impl.GenericManagerImpl;
import com.codeox.log.codeox.commen.enums.ResultEnum;
import com.codeox.log.codeox.commen.password.PasswordTool;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.commen.result.ResultUtil;
import com.codeox.log.codeox.domain.Admin;
import com.codeox.log.codeox.repository.AdminRepository;
import com.codeox.log.codeox.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * @autor : duqingqing
 * @data : 2018/10/2 0002
 * @time: 21:21
 * @package: com.codeox.log.codeox.service.impl
 */
@Component
public class AdminServiceImpl extends GenericManagerImpl<Admin, Long> implements AdminService {

    private AdminRepository adminRepository;
    @Autowired
    public void setAdminRepository(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
        this.dao = this.adminRepository;
    }

    /**
     * @Description: 添加管理员
     * @Param: String name: 管理员名字 String password : 管理员密码
     * @return: Result
     * @Date: 2018/10/2 0002
     */
    @Override
    public Result addAdmin(String name, String password) {
        Result result = null;
        PasswordTool passwordTool = new PasswordTool();
        if (passwordTool.verifyingLength(password)) {
            Admin admin = new Admin();
            admin.setName(name);
            admin.setPassword(passwordTool.encodePassword(password));
            Admin adminResult = adminRepository.save(admin);
            result = adminResult == null ? ResultUtil.error(ResultEnum.ADMIN_ADD_ERROR) : ResultUtil.success();
        } else {
            result = ResultUtil.error(ResultEnum.UNQUALIFIED_PASSWORD);
        }
        return result;
    }

    @Override
    public Admin findByName(String name) {
        return adminRepository.findByName(name);
    }


    /**
    * @Description: 更新管理员登入信息
    * @Param: admin : 管理员
    * @return: Result
    * @Date: 2018/10/2 0002
    */ 
    @Override
    @Transactional
    public Result updateLastEntry(Admin admin) {
        Result result = null;
        int entryNumber = admin.getEntryNumber()+1;
        int status = this.adminRepository.updateEntryInfo(admin,entryNumber,new Date());
        result = status>0?ResultUtil.success():ResultUtil.error(ResultEnum.ADMIN_UPDATE_ENTRY_INFO_ERROR);
        return result;
    }
}
