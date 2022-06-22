package com.vetalalien.miniservice.exception.dto;


import java.util.Collection;

public class Notification {

    public static final String ERROR_TYPE = "ERROR";
    public static final String INFO_TYPE = "INFO";

    private String notificationCode;

    private String notificationMessage;

    private String notificationType;

    private Object notificationDetails;

    private Collection<Long> objectIds;

    private Collection<String> objectUIDs;

    public String getNotificationCode() {
        return notificationCode;
    }

    public void setNotificationCode(String notificationCode) {
        this.notificationCode = notificationCode;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public Object getNotificationDetails() {
        return notificationDetails;
    }

    public void setNotificationDetails(Object notificationDetails) {
        this.notificationDetails = notificationDetails;
    }

    public Collection<Long> getObjectIds() {
        return objectIds;
    }

    public void setObjectIds(Collection<Long> objectIds) {
        this.objectIds = objectIds;
    }

    public void setObjectUIDs(Collection<String> objectUIDs) {
        this.objectUIDs = objectUIDs;
    }

    public Collection<String> getObjectUIDs() {
        return objectUIDs;
    }
}

