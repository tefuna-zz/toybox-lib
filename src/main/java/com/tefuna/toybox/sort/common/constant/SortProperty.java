package com.tefuna.toybox.sort.common.constant;

public enum SortProperty {

    MIN_VALUE("0", "min value"),
    MAX_VALUE("100", "max value"), ;

    private String value;
    private String dispName;

    private SortProperty(String value, String dispName) {
        this.value = value;
        this.dispName = dispName;
    }

    public String getValue() {
        return this.value;
    }

    public String getDispName() {
        return this.dispName;
    }
}
