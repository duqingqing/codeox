package com.codeox.log.codeox.domain;

import com.codeox.log.codeox.base.domain.BaseEntity;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @autor : duqingqing
 * @data : 2018/9/12 0012
 * @time: 15:50
 * @package: com.codeox.log.codeox.domain
 */
@Entity
@Table(name = "telephone")
@Getter
@Setter
@ToString
public class Telephone extends BaseEntity {
    @Column(name = "telePhoneNumber")
    private String telePhoneNumber;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
