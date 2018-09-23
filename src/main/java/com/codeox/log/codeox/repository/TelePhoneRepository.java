package com.codeox.log.codeox.repository;

import com.codeox.log.codeox.base.dao.GenericDao;
import com.codeox.log.codeox.domain.Telephone;
import com.codeox.log.codeox.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @autor : duqingqing
 * @data : 2018/9/12 0012
 * @time: 16:08
 * @package: com.codeox.log.codeox.repository
 */
@Repository
@Transactional
public interface TelePhoneRepository extends GenericDao<Telephone,Long> {
    @Query(value = "select telePhone from Telephone telePhone where telePhone.user=?1 and telePhone.deleted <>1")
    Telephone findSurvivalTelephone(User user);
    @Query(value = "update Telephone tele set tele.deleted=1 where tele.user=?1")
    @Modifying
    int changeSurvivalTelephoneToDeath(User user);
}
