package com.vetalalien.miniservice.dto;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class NamedDto extends LongIdDto implements HasName {
    private String name;

    public NamedDto() {
    }

    public NamedDto(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
