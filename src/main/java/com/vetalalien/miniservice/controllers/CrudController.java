package com.vetalalien.miniservice.controllers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Collection;
import java.util.Map;

import com.vetalalien.miniservice.dto.Create;
import com.vetalalien.miniservice.dto.LongIdDto;
import com.vetalalien.miniservice.dto.Update;
import com.vetalalien.miniservice.exception.NotFoundException;
import com.vetalalien.miniservice.init.RecursiveObjectInitiator;
import com.vetalalien.miniservice.object.mapper.CustomObjectMapper;
import com.vetalalien.miniservice.utils.ReflectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class CrudController<T extends LongIdDto> implements CrudResource<T, Long>, CorsController {
    @Autowired(
            required = false
    )
    private CustomObjectMapper customObjectMapper;

    public CrudController() {
    }

    @PostMapping
    @ResponseStatus(
            code = HttpStatus.CREATED
    )
    public T save(@Validated({Create.class}) @RequestBody T request) {
        return this.getCrudService().save(request);
    }

    @PutMapping({"{id}"})
    public T update(@PathVariable Long id, @Validated({Update.class}) @RequestBody T request) {
        request.setId(id);
        return this.getCrudService().update(request);
    }

    @DeleteMapping({"{id}"})
    @ResponseStatus(
            code = HttpStatus.NO_CONTENT
    )
    public void remove(@PathVariable Long id) {
        this.getCrudService().delete(id);
    }

    @GetMapping({"{id}"})
    public T get(@PathVariable Long id) {
        CrudService<T> service = this.getCrudService();
        T result = service.get(id);
        if (result == null) {
            throw new NotFoundException(id);
        } else {
            return result;
        }
    }

    @GetMapping
    public Collection<T> findAll(@RequestParam Map<String, String> requestParams) {
        return this.getCrudService().findAll();
    }

    @GetMapping(
            value = {"new"},
            produces = {"application/json;charset=UTF-8"}
    )
    public String getNew() {
        Class<T> genericClass = (Class<T>) ReflectionUtils.getInstance().getGenericParameterClass(this.getClass());
        T instance = (T) RecursiveObjectInitiator.getInstance().initiate(genericClass);
        return this.customObjectMapper != null ? this.customObjectMapper.writeValueAsString(instance) : "";
    }

    protected abstract CrudService<T> getCrudService();
}
