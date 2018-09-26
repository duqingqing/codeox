package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.base.service.impl.GenericManagerImpl;
import com.codeox.log.codeox.domain.Telephone;
import com.codeox.log.codeox.repository.TelePhoneRepository;
import com.codeox.log.codeox.service.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @autor : duqingqing
 * @data : 2018/9/26 0026
 * @time: 18:32
 * @package: com.codeox.log.codeox.service.impl
 */
@Component
public class TelephoneServiceImpl extends GenericManagerImpl<Telephone,Long> implements TelephoneService {
    @Autowired
    private TelePhoneRepository telePhoneRepository;
}
