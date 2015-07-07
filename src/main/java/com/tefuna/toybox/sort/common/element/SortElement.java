package com.tefuna.toybox.sort.common.element;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author tefuna
 *
 */
public class SortElement {

    private int id;
    @JsonProperty("val")
    private int value;
    @JsonProperty("prepos")
    private int prePosition;
    @JsonProperty("pos")
    private int position;
    private boolean sorted;

    /**
     * default constructor.
     */
    public SortElement() {
    }

    /**
     * copy constructor.
     * 
     * @param se
     */
    public SortElement(SortElement se) {
        this.id = se.getId();
        this.value = se.getValue();
        this.prePosition = se.getPrePosition();
        this.position = se.getPosition();
        this.sorted = se.isSorted();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPrePosition() {
        return prePosition;
    }

    public void setPrePosition(int prePosition) {
        this.prePosition = prePosition;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isSorted() {
        return sorted;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }

    @Override
    public String toString() {
        return "{" + this.id + ", " + this.value + ", " + this.prePosition + ", " + this.position + ", " + this.sorted
                + "}";
    }

}
