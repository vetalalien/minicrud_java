package com.vetalalien.miniservice.validator;

import java.lang.reflect.AnnotatedType;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vetalalien.miniservice.dto.EnumWithId;

public class EnumWithIdValidator implements ConstraintValidator<EnumWithIdValid, Integer> {

    private Set<Integer> values = new HashSet<>();

    @Override
    public void initialize(EnumWithIdValid constraintAnnotation) {
        Class<? extends Enum<?>> clazz = constraintAnnotation.enumClass();
        checkSupport(clazz);
        Object[] constants = clazz.getEnumConstants();
        for (Object constant : constants) {
            EnumWithId value = (EnumWithId) constant;
            values.add(value.getId());
        }
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value == null || values.contains(value);
    }

    private void checkSupport(Class<? extends Enum<?>> clazz) {
        AnnotatedType[] interfaces = clazz.getAnnotatedInterfaces();
        for (AnnotatedType current : interfaces) {
            if (Objects.equals(current.getType().getTypeName(), EnumWithId.class.getName())) {
                return;
            }
        }
        throw new IllegalArgumentException("Enum must implements interface " + EnumWithId.class.getName());
    }
}

