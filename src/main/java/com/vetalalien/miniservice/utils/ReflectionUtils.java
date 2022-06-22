package com.vetalalien.miniservice.utils;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Set;

public class ReflectionUtils {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

    private static final ReflectionUtils INSTANCE = new ReflectionUtils();

    private ReflectionUtils(){}

    public static ReflectionUtils getInstance() {
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    public <T> Class<?> getGenericParameterClass(Class<T> clazz) {
        Objects.requireNonNull(clazz, "Class is required");
        ParameterizedType genericSuperclass = (ParameterizedType) clazz.getGenericSuperclass();
        if (genericSuperclass.getActualTypeArguments().length != 0) {
            Type type = genericSuperclass.getActualTypeArguments()[0];
            return (Class<T>) type;
        } else {
            throw new IllegalArgumentException("Can't get generic parameter from " + clazz.getCanonicalName());
        }
    }


    public Set<Class<?>> collectClasses(String packageName, Class<? extends Annotation> annotationClass) {
        Objects.requireNonNull(packageName, "Set the package for scan instead of null");
        Objects.requireNonNull(annotationClass, "Annotation class is required");
        if (packageName.isEmpty()) {
            throw new IllegalArgumentException("Set the package for scan instead of empty");
        }
        Reflections reflections = new Reflections(packageName);
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(annotationClass);


        logger.info("Collected {} classes in package {} with annotation class {}",
                annotatedClasses.size(), packageName, annotationClass);
        return annotatedClasses;
    }
}

