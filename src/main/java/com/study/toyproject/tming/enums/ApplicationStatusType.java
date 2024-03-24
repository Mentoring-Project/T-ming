package com.study.toyproject.tming.enums;

public enum ApplicationStatusType {
    APPROVAL("승인"), REJECTED("거절"), REQUEST("요청");

    private String value;

    ApplicationStatusType(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
