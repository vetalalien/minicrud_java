package com.vetalalien.miniservice.dto;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javax.validation.constraints.Null;

public abstract class Dto<T> {
    @Null(
            groups = {Create.class}
    )
    private T id;

    public Dto() {
    }

    public Dto(T id) {
        this.id = id;
    }

    public T getId() {
        return this.id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Dto)) {
            return false;
        } else {
            Dto<?> dto = (Dto)o;
            return this.getId() != null ? this.getId().equals(dto.getId()) : dto.getId() == null;
        }
    }

    public int hashCode() {
        return this.getId() != null ? this.getId().hashCode() : 0;
    }
}
