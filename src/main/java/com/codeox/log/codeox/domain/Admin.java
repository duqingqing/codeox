package com.codeox.log.codeox.domain;

import com.codeox.log.codeox.base.domain.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @autor : duqingqing
 * @data : 2018/10/2 0002
 * @time: 21:17
 * @package: com.codeox.log.codeox.domain
 */
@Table(name = "admin")
@Entity
@Setter
@Getter
@ToString
public class Admin extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    //记录上一次登入时间
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LastEntry")
    protected Date lastEntry = new Date();
    //记录登入次数
    @Column(name = "entryNumber", columnDefinition = "int default 0", nullable = false)
    private int entryNumber;
}
