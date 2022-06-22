package com.vetalalien.miniservice.service.mapper;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.Collection;
import java.util.function.Consumer;

import com.vetalalien.miniservice.entity.LongIdEntity;


public class MapToDtoConsumer implements Consumer<LongIdEntity> {
    private final Collection dtos;
    private final BeanMapper mapper;

    public MapToDtoConsumer(Collection dtos, BeanMapper mapper) {
        this.dtos = dtos;
        this.mapper = mapper;
    }

    public void accept(LongIdEntity entity) {
        this.dtos.add(this.mapper.mapToDto(entity));
    }
}

