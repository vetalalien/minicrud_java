package com.vetalalien.miniservice.object.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import java.util.Arrays;
import java.util.Map;

/**
 * Wrapper over {@link ObjectMapper}
 */
public class ObjectMapperWrapper implements CustomObjectMapper {

    private final ObjectMapper objectMapper;

    public ObjectMapperWrapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * @see ObjectMapper#writeValueAsString(Object)
     */
    @Override
    public String writeValueAsString(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T mapToBean(Map<String, Object> map, Class<T> toType) {
        return objectMapper.convertValue(map, toType);
    }

    @Override
    public <T> Map<String, Object> beanToMap(T bean) {
        return objectMapper.convertValue(bean, Map.class);
    }

}

