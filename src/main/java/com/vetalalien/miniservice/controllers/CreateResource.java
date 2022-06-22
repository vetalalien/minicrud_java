package com.vetalalien.miniservice.controllers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import com.vetalalien.miniservice.dto.Create;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface CreateResource<T> {
    @PostMapping
    T save(@Validated({Create.class}) @RequestBody T var1);
}

