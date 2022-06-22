package com.vetalalien.miniservice.service.mapper;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


public interface BeanMapper<D, E> {
    E mapToEntity(D var1);

    E updateEntityWithDto(D var1, E var2);

    D mapToDto(E var1);
}

