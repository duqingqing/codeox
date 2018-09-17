package com.codeox.log.codeox.service.impl;

import com.codeox.log.codeox.domain.JwtUser;
import com.codeox.log.codeox.domain.User;
import com.codeox.log.codeox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @autor : duqingqing
 * @data : 2018/9/17 0017
 * @time: 19:30
 * @package: com.codeox.log.codeox.filter
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        return new JwtUser(user);
    }

}
