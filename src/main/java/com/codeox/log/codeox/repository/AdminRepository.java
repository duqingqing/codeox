package com.codeox.log.codeox.repository;

import com.codeox.log.codeox.base.dao.GenericDao;
import com.codeox.log.codeox.domain.Admin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * @autor : duqingqing
 * @data : 2018/10/2 0002
 * @time: 21:19
 * @package: com.codeox.log.codeox.repository
 */
@Repository
@Transactional
public interface AdminRepository extends GenericDao<Admin, Long> {
    /**
     * 通过名字查找管理员
     * @param name
     * @return
     */
    @Query(value = "select admin  from Admin  admin where admin.name = ?1")
    Admin findByName(String name);

    /**
     * @param admin 管理员
     * @param entryNumber 登入次数
     * @param date 登入时间
     * @return int
     */
    @Modifying
    @Query(value = "update Admin admin set admin.lastEntry=:date , admin.entryNumber=:entryNumber where admin =:admin")
    int updateEntryInfo(@Param(value = "admin") Admin admin, @Param(value = "entryNumber")int entryNumber,@Param(value = "date") Date date);


}
