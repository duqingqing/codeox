package com.codeox.log.codeox.domain;

import com.codeox.log.codeox.base.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @autor : duqingqing
 * @data : 2018/9/23 0023
 * @time: 15:24
 * @package: com.codeox.log.codeox.domain
 */
@Table(name="comment")
@Entity
@Setter
@Getter
@ToString
public class Comment extends BaseEntity {
    @Column(name="content",columnDefinition = "LONGTEXT")
    private String content;

    @ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "blogId")
    private Blog blog;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;
}
