package com.vetalalien.miniservice.dto;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.Objects;

public class EnumDto implements HasName {
    private String code;
    private String name;

    public EnumDto() {
    }

    public EnumDto(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equalsOrigin(Enum origin) {
        if (origin == null) {
            return false;
        } else {
            String originName = origin.name();
            if (this.getCode() == null) {
                return originName == null;
            } else {
                boolean equals = this.getCode().equals(originName);
                if (equals || !"".equals(this.getCode()) && !"UNDEFINED".equals(this.getCode())) {
                    return equals;
                } else {
                    return "UNDEFINED".equals(originName) || "".equals(originName);
                }
            }
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            EnumDto enumDto = (EnumDto)o;
            return Objects.equals(this.getCode(), enumDto.getCode()) && Objects.equals(this.getName(), enumDto.getName());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getCode(), this.getName()});
    }
}
