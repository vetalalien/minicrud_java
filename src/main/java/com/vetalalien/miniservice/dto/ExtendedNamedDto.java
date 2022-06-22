package com.vetalalien.miniservice.dto;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.HashMap;
import java.util.Map;

public class ExtendedNamedDto extends NamedDto {
    private Map<String, Object> properties = new HashMap();

    public ExtendedNamedDto() {
    }

    public ExtendedNamedDto(Long id, String name) {
        super(id, name);
    }

    public ExtendedNamedDto addProperty(String key, Object value) {
        this.properties.put(key, value);
        return this;
    }

    public Map<String, Object> getProperties() {
        return this.properties;
    }
}
