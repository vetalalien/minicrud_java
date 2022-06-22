package com.vetalalien.miniservice.controllers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface DeleteResource<ID> {
    @DeleteMapping({"{id}"})
    void remove(@PathVariable ID var1);
}

