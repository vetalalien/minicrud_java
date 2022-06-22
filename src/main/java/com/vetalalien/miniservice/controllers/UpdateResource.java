package com.vetalalien.miniservice.controllers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.vetalalien.miniservice.dto.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UpdateResource<T, ID> {
    @PutMapping({"{id}"})
    T update(@PathVariable ID var1, @Validated({Update.class}) @RequestBody T var2);
}

