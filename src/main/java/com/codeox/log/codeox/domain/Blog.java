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
 * @data : 2018/9/23 0023
 * @time: 14:47
 * @package: com.codeox.log.codeox.domain
 */
@Table(name="blog")
@Entity
@Setter
@Getter
@ToString
public class Blog extends BaseEntity {
    @Column(name="title")
    private String title;
    @Column(name="content",columnDefinition="LONGTEXT")
    private String content;
    @Column(name="author")
    private User author;
    @Column(name="readers",columnDefinition="bigint default 0")
    private long readers;

}
