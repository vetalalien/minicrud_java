package com.vetalalien.miniservice.alternative.exception;


import com.netflix.hystrix.exception.ExceptionNotWrappedByHystrix;
import com.vetalalien.miniservice.exception.dto.Notification;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;
import static java.util.Optional.ofNullable;

/**
 * Base exception class for all custom exceptions for next conversion to notifications
 */
public abstract class BaseException extends RuntimeException implements ExceptionNotWrappedByHystrix {

    private static final long serialVersionUID = 1L;

    private final String code;

    private final Collection<String> objectUids;

    public BaseException(String message, String code, String... objectUids) {
        super(message);
        this.code = code;
        this.objectUids = initObjectIds(objectUids);
    }

    public BaseException(String message, Throwable cause, String code, String... objectUids) {
        super(message, cause);
        this.code = code;
        this.objectUids = initObjectIds(objectUids);
    }

    private List<String> initObjectIds(String[] objectIds) {
        return ofNullable(objectIds)
                .map(ids -> unmodifiableList(Stream.of(objectIds)
                        .collect(Collectors.toList())))
                .orElse(Collections.emptyList());
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return Notification.ERROR_TYPE;
    }

    public Collection<String> getObjectUids() {
        return objectUids;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("code='").append(code).append('\'');
        sb.append(", objectUids=").append(objectUids);
        sb.append(" super=").append(super.toString()).append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseException that = (BaseException) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(objectUids, that.objectUids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, objectUids);
    }
}
