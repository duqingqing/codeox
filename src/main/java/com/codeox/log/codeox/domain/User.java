package com.codeox.log.codeox.domain;

import com.codeox.log.codeox.base.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @autor : duqingqing
 * @data : 2018/9/12 0012
 * @time: 9:29
 * @package: com.codeox.log.codeox.domain
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User extends BaseEntity{
    @Column(name="username",unique = true)
    private String username;
    @Column(name="psaaword")
    private String password;
    @Column(name = "role")
    private String role;
}
