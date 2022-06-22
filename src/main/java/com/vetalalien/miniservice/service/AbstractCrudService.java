package com.vetalalien.miniservice.service;

import java.util.*;

import com.vetalalien.miniservice.controllers.CrudService;
import com.vetalalien.miniservice.dto.CommonEntityFilterDto;
import com.vetalalien.miniservice.dto.LongIdDto;
import com.vetalalien.miniservice.dto.PaginationDto;
import com.vetalalien.miniservice.entity.LongIdEntity;
import com.vetalalien.miniservice.exception.NotFoundException;
import com.vetalalien.miniservice.repository.BaseRepository;
import com.vetalalien.miniservice.service.mapper.BeanMapper;
import com.vetalalien.miniservice.service.mapper.MapToDtoConsumer;
import com.vetalalien.miniservice.utils.ReflectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.transaction.annotation.Transactional;


import static java.util.Collections.emptyList;

public abstract class AbstractCrudService<T extends LongIdDto, E extends LongIdEntity> implements
        CrudService<T> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractCrudService.class);

    @Override
    @Transactional
    public T save(T dto) {
        logInfo("Save dto {}", dto);
        checkDtoForSave(dto);
        E entity = mapToEntity(dto);
        entity = entityPreSaveAction(entity);
        E savedEntity = getRepository().save(entity);
        return mapToDto(savedEntity);
    }

    protected E entityPreSaveAction(E entity) {
        return entity;
    }

    protected void checkDtoForSave(T dto) {
        throwExceptionIfNullInput(dto);
    }

    @Override
    @Transactional
    public T update(T dto) {
        logInfo("Update dto {}", dto);
        checkDtoForUpdate(dto);
        if (dto.getId() == null) {
            return this.save(dto);
        }
        E originEntity = getRepository().findOne(dto.getId());
        if (originEntity == null) {
            return this.save(dto);
        }
        originEntity = updateEntityWithDto(originEntity, dto);
        originEntity = entityPreUpdateAction(originEntity);
        E updatedEntity = getRepository().save(originEntity);
        return mapToDto(updatedEntity);
    }

    protected E entityPreUpdateAction(E updatedEntity) {
        return updatedEntity;
    }

    protected void checkDtoForUpdate(T dto) {
        throwExceptionIfNullInput(dto);
    }

    private void throwExceptionIfNullInput(T dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Input is null");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public T get(Long id) {
        logInfo("Get dto by id {}", id);
        checkIdForNull(id);
        E entity = getRepository().findOne(id);
        if (entity == null) {
            logInfo("Object by id {} not found", id);
            return null;
        }
        return mapToDto(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        logInfo("Remove object by id {}", id);
        checkIdForNull(id);
        checkIfEntityForIdExist(id);
        preDeleteAction(id);
        getRepository().delete(id);
    }

    private void checkIfEntityForIdExist(Long id) {
        if (!getRepository().exists(id)) {
            throw new NotFoundException(id);
        }
    }

    protected void preDeleteAction(Long id) {

    }

    private void checkIdForNull(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Unable to perform operation with null id");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<T> findAll() {
        Iterable<E> entities = getRepository().findAll();
        Collection<T> dtos = new LinkedList<>();
        MapToDtoConsumer consumer = new MapToDtoConsumer(dtos, getMapper());
        entities.forEach(consumer);
        return dtos;
    }


    @Override
    @Transactional
    public PaginationDto<T> filtered(CommonEntityFilterDto dto) {
        if(!preFilteredAction(dto)) return createEmptyFilterResult(dto);
        PaginationDto<T> pageDto = filteredAction(dto);
        postFilteredAction(pageDto);
        return pageDto;
    }

    protected PaginationDto<T> filteredAction(CommonEntityFilterDto dto){
        return createEmptyFilterResult(dto);
    }

    private PaginationDto<T> createEmptyFilterResult(CommonEntityFilterDto filterDto) {
        Page<T> response = new PageImpl<>(emptyList());
        return new PaginationDto<>(filterDto, response);
    }

    private final void postFilteredAction(PaginationDto<T> pageDto){
        List<T> dtos = null;
        if(Objects.nonNull(pageDto)){
            if(Objects.nonNull(pageDto.getResponse())){
                dtos = pageDto.getResponse().getContent();
            }
        }
        if(Objects.nonNull(dtos)){
            Page<T> checkedPage = pageDto.getResponse()
                    .map(dto -> {
                        if(!hasReadAccess(dto)){
                            return getNotAccessibleDto();
                        }
                        return dto;
                    });
            pageDto.setResponse(checkedPage);
        }
    }

    protected T getNotAccessibleDto(){
        Class<T> entityClass = (Class<T>) ReflectionUtils.getInstance().getGenericParameterClass(this.getClass());
        T dto = null;
        try {
            dto = entityClass.newInstance();
        } catch (Exception e) {
            logError(e.getMessage(), e);
        }
        return dto;
    }

    protected boolean hasReadAccess(T dto) {
        return false;
    }


    protected boolean preFilteredAction(CommonEntityFilterDto dto){
        return true;
    }

    protected T mapToDto(E entity) {
        return getMapper().mapToDto(entity);
    }

    protected E updateEntityWithDto(E originEntity, T dto) {
        return this.getMapper().updateEntityWithDto(dto, originEntity);
    }

    protected E mapToEntity(T dto) {
        return getMapper().mapToEntity(dto);
    }

    protected abstract BeanMapper<T, E> getMapper();

    protected abstract BaseRepository<E> getRepository();

    protected boolean isEmpty(String value) {
        return StringUtils.isBlank(value);
    }

    protected void logInfo(String format, Object arg) {
        logger.info(format, arg);
    }

    protected void logError(String msg, Throwable t) {
        logger.error(msg, t);
    }
}
