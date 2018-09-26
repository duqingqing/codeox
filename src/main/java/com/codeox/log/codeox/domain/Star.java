package com.codeox.log.codeox.domain;

import com.codeox.log.codeox.base.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.ClassRule;

import javax.persistence.*;
import java.util.List;

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

    @Column(name="stars",columnDefinition = "biging default 0")
    private long starNumber;

    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="userID")
    private User user;

    @ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="blogID")
    private Blog blog;
}
