package com.vetalalien.miniservice.dto;

public class CommonCountFilterDto {

    public static final String DEFAULT_DESCRIPTION="Все";
    public static final String DEFAULT_VALUE="";

    public enum FilterType{
        RADIO
    }

    private String value;
    private String description;
    private long count;
    private String entityClass;
    private FilterType type;

    public CommonCountFilterDto() {
    }


    public CommonCountFilterDto(String value, long count, String entityClass) {
        this.value = value;
        this.count = count;
        this.entityClass = entityClass;
    }

    public CommonCountFilterDto(long count, String entityClass, CommonCountFilterDto.FilterType type) {
        this.count = count;
        this.entityClass = entityClass;
        this.type = type;
        description=DEFAULT_DESCRIPTION;
        value=DEFAULT_VALUE;
    }

    public CommonCountFilterDto(String value, String description, long count, String entityClass, CommonCountFilterDto.FilterType type) {
        this.value = value;
        this.description = description;
        this.count = count;
        this.entityClass = entityClass;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(String entityClass) {
        this.entityClass = entityClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FilterType getType() {
        return type;
    }

    public void setType(FilterType type) {
        this.type = type;
    }
}

