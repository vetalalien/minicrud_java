package com.vetalalien.miniservice.service;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Collection;
import java.util.Map;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Profile({"!test"})
@Lazy
public interface CrudApiInterface<T, K> {
    @RequestMapping(
            method = {RequestMethod.GET},
            produces = {"application/json"}
    )
    Collection<T> findAll(@RequestParam("requestParams") Map<String, String> var1);

    @RequestMapping(
            method = {RequestMethod.POST},
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    T save(@RequestBody T var1);

    @RequestMapping(
            value = {"/{id}"},
            method = {RequestMethod.PUT},
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    T update(@PathVariable("id") K var1, @RequestBody T var2);

    @RequestMapping(
            value = {"/{id}"},
            method = {RequestMethod.GET},
            produces = {"application/json"}
    )
    T get(@PathVariable("id") K var1);

    @RequestMapping(
            value = {"/{id}"},
            method = {RequestMethod.DELETE}
    )
    void remove(@PathVariable("id") K var1);
}

