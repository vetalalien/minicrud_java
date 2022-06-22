package com.vetalalien.miniservice.dto;


import java.util.Objects;

public enum InterestCorrectionMethod {

    ADDITION("ADDITION", "Сложение"),
    MULTIPLICATION("MULTIPLICATION", "Умножение");

    String code;

    String name;

    InterestCorrectionMethod(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static InterestCorrectionMethod getInterestCorrectionMethodByCode(String code) {
        InterestCorrectionMethod type = null;
        for (InterestCorrectionMethod item : InterestCorrectionMethod.values()) {
            if (Objects.equals(item.getCode(), code)) {
                type = item;
                break;
            }
        }
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}

