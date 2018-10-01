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

    /**
    * @Description: 查找用户当前使用的电话号码
    * @Param: User user
    * @return: Telephone
    * @Date: 2018/9/30 0030
    */ 
    @Query(value = "select telePhone from Telephone telePhone where telePhone.user=?1 and telePhone.deleted <>1")
    Telephone findSurvivalTelephone(User user);

    /**
    * @Description: 把当前用户使用的电话号的delete=1
    * @Param: User user
    * @return: int
    * @Date: 2018/9/30 0030
    */ 
    @Modifying
    @Query(value = "update Telephone tele set tele.deleted=1 where tele.user=?1")
    int changeSurvivalTelephoneToDeath(User user);
}
