package com.tefuna.toybox.sort.common.element;

import java.util.ArrayList;
import java.util.List;

import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;

public class SortResult {

    private SortName name;
    private SortMethod method;
    private SortElement[] original;
    private SortElement[] complete;
    private List<SortSteps> steps = new ArrayList<SortSteps>();
    private long spent;

    public SortName getName() {
        return name;
    }

    public void setName(SortName name) {
        this.name = name;
    }

    public SortMethod getMethod() {
        return method;
    }

    public void setMethod(SortMethod method) {
        this.method = method;
    }

    public SortElement[] getOriginal() {
        return original;
    }

    public void setOriginal(SortElement[] original) {
        this.original = original;
    }

    public SortElement[] getComplete() {
        return complete;
    }

    public void setComplete(SortElement[] complete) {
        this.complete = complete;
    }

    public List<SortSteps> getSteps() {
        return steps;
    }

    public void setSteps(List<SortSteps> steps) {
        this.steps = steps;
    }

    public long getSpent() {
        return spent;
    }

    public void setSpent(long spent) {
        this.spent = spent;
    }

}
