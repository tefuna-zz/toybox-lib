package com.tefuna.toybox.sort.common.constant;

public enum SortOrder {

    ASC("01", "ascending"),
    DESC("02", "descending");

    private String value;
    private String dispName;

    private SortOrder(String value, String dispName) {
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
