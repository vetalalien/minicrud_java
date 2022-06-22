package com.vetalalien.miniservice.exception;


import com.vetalalien.miniservice.alternative.exception.BaseException;

public class NotFoundException extends BaseException {

    public static final String DEFAULT_ERROR_CODE = "ER_NOT_FOUND";

    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super("Объект не найден в БД", DEFAULT_ERROR_CODE);
    }

    public NotFoundException(Object id, String beanType) {
        super(String.format("Объект с идентификатором %s и типом %s не найден в БД", id, beanType), DEFAULT_ERROR_CODE);
    }

    public NotFoundException(Object id) {
        super(String.format("Объект с идентификатором %s не найден в БД", id), DEFAULT_ERROR_CODE);
    }

    public NotFoundException(String message) {
        super(message, DEFAULT_ERROR_CODE);
    }
}
