package com.vetalalien.miniservice.entity;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NamedEntityWithLongId extends LongIdEntity {
    @Column(
            name = "name"
    )
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NamedEntityWithLongId() {
    }

    public NamedEntityWithLongId(Long id, String name) {
        super(id);
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof NamedEntityWithLongId)) {
            return false;
        } else if (!super.equals(o)) {
            return false;
        } else {
            NamedEntityWithLongId that = (NamedEntityWithLongId)o;
            return this.getName() != null ? this.getName().equals(that.getName()) : that.getName() == null;
        }
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (this.getName() != null ? this.getName().hashCode() : 0);
        return result;
    }
}
