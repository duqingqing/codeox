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
 * @data : 2018/9/30 0030
 * @time: 19:32
 * @package: com.codeox.log.codeox.domain
 */
@Table(name="category")
@Entity
@Setter
@Getter
@ToString
public class Category extends BaseEntity {
    @Column(name="name")
    private String name;
}
