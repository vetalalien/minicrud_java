package com.vetalalien.miniservice.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class LongIdEntity implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LongIdEntity() {
    }

    public LongIdEntity(Long id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof LongIdEntity)) {
            return false;
        } else {
            LongIdEntity entity = (LongIdEntity)o;
            return this.getId() != null ? this.getId().equals(entity.getId()) : entity.getId() == null;
        }
    }

    public int hashCode() {
        return this.getId() != null ? this.getId().hashCode() : 0;
    }
}
