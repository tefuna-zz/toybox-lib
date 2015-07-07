package com.tefuna.toybox.sort.common.constant;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SortMethod {

    EXCHANGING("01", "exchanging"),
    SELECTION("02", "selection"),
    INSERTION("03", "insertion"),
    PARTITIONING("04", "partitioning"),
    MERGING("05", "merging"),
    SHUFFLING("06", "shuffling");

    private String value;
    private String dispName;

    private SortMethod(String value, String dispName) {
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
