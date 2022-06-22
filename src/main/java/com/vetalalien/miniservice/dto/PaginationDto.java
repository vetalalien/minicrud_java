package com.vetalalien.miniservice.dto;


import org.springframework.data.domain.Page;

import java.util.List;

public class PaginationDto<T>  {
    private CommonEntityFilterDto request;
    private Page<T> response;
    private List<CommonCountFilterDto> groupedBy;

    public PaginationDto(){

    }

    public PaginationDto(CommonEntityFilterDto request, Page<T> response) {
        this.request = request;
        this.response = response;
    }

    public PaginationDto(CommonEntityFilterDto request, Page<T> response, List<CommonCountFilterDto> groupedBy) {
        this.request = request;
        this.response = response;
        this.groupedBy = groupedBy;
    }

    public CommonEntityFilterDto getRequest() {
        return request;
    }

    public void setRequest(CommonEntityFilterDto request) {
        this.request = request;
    }

    public Page<T> getResponse() {
        return response;
    }

    public void setResponse(Page<T> response) {
        this.response = response;
    }

    public List<CommonCountFilterDto> getGroupedBy() {
        return groupedBy;
    }

    public void setGroupedBy(List<CommonCountFilterDto> groupedBy) {
        this.groupedBy = groupedBy;
    }
}

