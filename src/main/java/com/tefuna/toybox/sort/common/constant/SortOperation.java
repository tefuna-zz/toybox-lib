package com.tefuna.toybox.sort.common.constant;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SortOperation {

    COMPARING("01", "comparing"),
    EXCHANGING("02", "exchanging"),
    COMPLETING("03", "completing");

    private String value;
    private String dispName;

    private SortOperation(String value, String dispName) {
        this.value = value;
        this.dispName = dispName;
    }

    public String getValue() {
        return this.value;
    }

    @JsonValue
    public String getDispName() {
        return this.dispName;
    }

}
