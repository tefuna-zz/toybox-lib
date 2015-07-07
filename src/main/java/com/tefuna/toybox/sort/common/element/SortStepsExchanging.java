package com.tefuna.toybox.sort.common.element;

import java.util.ArrayList;
import java.util.List;

import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SortStepsExchanging implements SortSteps {

    private int seq;
    private SortOperation operation;
    @JsonProperty("swapelem")
    private List<SortElement> swapElement = new ArrayList<SortElement>();

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public SortOperation getOperation() {
        return this.operation;
    }

    public void setOperation(SortOperation operation) {
        this.operation = operation;
    }

    public List<SortElement> getSwapElement() {
        return swapElement;
    }

    public void setSwapElement(List<SortElement> swapElement) {
        this.swapElement = swapElement;
    }

    @Override
    public void updateSorted(int id, boolean sorted) {

        for (SortElement se : this.swapElement) {
            if (se.getId() == id) {
                se.setSorted(sorted);
            }
        }
    }

}
