package com.codeox.log.codeox.service;

import com.codeox.log.codeox.base.service.GenericManager;
import com.codeox.log.codeox.commen.result.Result;
import com.codeox.log.codeox.domain.Admin;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * @autor : duqingqing
 * @data : 2018/10/2 0002
 * @time: 21:20
 * @package: com.codeox.log.codeox.service
 */
public interface AdminService extends GenericManager<Admin, Long> {
    Result addAdmin(String name,String password);
    Admin findByName(String name);
    Result updateLastEntry(Admin admin);
}
