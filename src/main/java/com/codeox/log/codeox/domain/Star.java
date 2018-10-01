package com.codeox.log.codeox.domain;

import com.codeox.log.codeox.base.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @autor : duqingqing
 * @data : 2018/9/23 0023
 * @time: 14:57
 * @package: com.codeox.log.codeox.domain
 */
@Table(name="star")
@Entity
@Getter
@Setter
@ToString
public class Star extends BaseEntity{

    @Column(name="status",columnDefinition = "binary default 0",nullable = false)
    private int status;

    @OneToOne
    @JoinColumn(name="author_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="article_id")
    private Blog blog;
}
