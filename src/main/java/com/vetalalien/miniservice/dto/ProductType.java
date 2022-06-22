package com.vetalalien.miniservice.dto;


import static com.vetalalien.miniservice.dto.EnumUtils.UNDEFINED_NAME_EMPTY;

import java.util.Objects;

public enum ProductType implements EnumWithId {
    UNDEFINED(0, UNDEFINED_NAME_EMPTY),
    MORTGAGE(1, "Ипотечный продукт"),
    OPTION(2, "Опция"),
    ACTION(3, "Акция"),
    VERSION(4, "Версия");

    Integer id;

    String name;

    ProductType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ProductType getProductTypeById(Integer id) {
        ProductType productType = UNDEFINED;
        if (id == null) {
            return productType;
        }
        for (ProductType item : ProductType.values()) {
            if (Objects.equals(item.getId(), id)) {
                productType = item;
                break;
            }
        }
        return productType;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
