package com.vetalalien.miniservice.controllers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Collection;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReadResource<T, ID> {
    @GetMapping({"{id}"})
    T get(@PathVariable ID var1);

    @GetMapping
    Collection<T> findAll(@RequestParam Map<String, String> var1);
}
