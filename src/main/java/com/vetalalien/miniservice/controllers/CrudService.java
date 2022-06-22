package com.vetalalien.miniservice.controllers;


import java.util.Collection;

import com.vetalalien.miniservice.dto.CommonEntityFilterDto;
import com.vetalalien.miniservice.dto.LongIdDto;
import com.vetalalien.miniservice.dto.PaginationDto;

public interface CrudService<T extends LongIdDto> {

    T save(T dto);

    T update(T dto);

    T get(Long id);

    void delete(Long id);

    Collection<T> findAll();

    PaginationDto<T> filtered(CommonEntityFilterDto dto);
}

