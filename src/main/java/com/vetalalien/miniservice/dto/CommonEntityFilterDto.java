package com.vetalalien.miniservice.dto;


import com.vetalalien.miniservice.repository.filter.Condition;


import java.util.List;

public class CommonEntityFilterDto {

    private int size;

    private int page;

    private List<Condition> sortBy;

    private List<Condition> searchConditions;

    private String property;

    public CommonEntityFilterDto() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Condition> getSortBy() {
        return sortBy;
    }

    public void setSortBy(List<Condition> sortBy) {
        this.sortBy = sortBy;
    }

    public List<Condition> getSearchConditions() {
        return searchConditions;
    }

    public void setSearchConditions(List<Condition> searchConditions) {
        this.searchConditions = searchConditions;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "CommonEntityFilterDto{" +
                "size=" + size +
                ", page=" + page +
                ", sortBy=" + sortBy +
                ", searchConditions=" + searchConditions +
                ", property='" + property + '\'' +
                '}';
    }
}
