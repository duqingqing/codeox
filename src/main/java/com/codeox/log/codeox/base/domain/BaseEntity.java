package com.codeox.log.codeox.base.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Getter
@Setter
@Slf4j
public class BaseEntity extends BaseDomain {


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATECREATED")
    protected Date dateCreated = new Date();

    /**
     * 实体修改时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATEMODIFIED")
    protected Date dateModified = new Date();

    /**
     * 实体是否被删除
     */
    @Column(name = "DELETED",columnDefinition = "int default 0")
    protected int deleted;

    @Column(name = "ENTITY_NAME")
    protected String entityName;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    public boolean equals(Object obj) {
        if (null != obj) {
            if (obj instanceof BaseEntity) {
                BaseEntity domain = (BaseEntity) obj;
                if (this.id == domain.id) {
                    return true;
                }
            }
        }
        return false;
    }
    public int hashCode() {
        if (this.id == null) {
            this.id = Long.valueOf(0);
        }
        return HashCodeBuilder.reflectionHashCode(this.id);
    }
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
    public int isDeleted() {
        return deleted;
    }
}
