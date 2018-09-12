package com.codeox.log.codeox.repository;

import com.codeox.log.codeox.base.dao.GenericDao;
import com.codeox.log.codeox.domain.Telephone;
import org.springframework.data.jpa.repository.Query;

/**
 * @autor : duqingqing
 * @data : 2018/9/12 0012
 * @time: 16:08
 * @package: com.codeox.log.codeox.repository
 */
public interface TelePhoneRepository extends GenericDao<Telephone,Long> {
//    @Query(value = "select telePhone from Telephone ")
//    public Telephone findSurvivalTelephone();
}
