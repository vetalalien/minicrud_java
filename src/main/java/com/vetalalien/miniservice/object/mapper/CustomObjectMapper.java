package com.vetalalien.miniservice.object.mapper;


import java.util.Map;

/**
 * Custom object mapper
 */
public interface CustomObjectMapper {

    String writeValueAsString(Object value);

    /**
     * Returns a new instance of the class represented by this {@code toType} object  whose property
     * names are the keys of specified {@code map} and property values are the values of corresponding
     * keys
     */
    <T> T mapToBean(Map<String, Object> map, Class<T> toType);

    /**
     * Returns a {@link Map} view whose keys are the property names of {@code bean} and values are the
     * contents of {@code bean} properties.
     */
    <T> Map<String, Object> beanToMap(T bean);

}

