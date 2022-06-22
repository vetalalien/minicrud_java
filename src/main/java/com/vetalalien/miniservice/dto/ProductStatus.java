package com.vetalalien.miniservice.dto;


import static com.vetalalien.miniservice.dto.EnumUtils.UNDEFINED_NAME_EMPTY;

import java.util.Objects;

public enum ProductStatus implements EnumWithId {

    UNDEFINED(0, UNDEFINED_NAME_EMPTY),
    NEW(1, "Новый"),
    IN_PROGRESS(2, "Действует"),
    EDITING(3, "Корректировка"),
    ARCHIVE(4, "Архив");

    Integer id;

    String name;

    ProductStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ProductStatus getProductStatusById(Integer id) {
        ProductStatus status = UNDEFINED;
        if (id == null) {
            return status;
        }
        for (ProductStatus item : ProductStatus.values()) {
            if (Objects.equals(item.getId(), id)) {
                status = item;
                break;
            }
        }
        return status;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

