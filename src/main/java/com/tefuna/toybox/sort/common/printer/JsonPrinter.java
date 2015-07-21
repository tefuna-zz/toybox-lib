package com.tefuna.toybox.sort.common.printer;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.element.SortResult;
import com.tefuna.toybox.sort.common.element.SortStep;

public class JsonPrinter implements Printer {

    private SortResult result = new SortResult();

    @Override
    public void setSortName(SortName sortName) {
        this.result.setName(sortName);
    }

    @Override
    public void setSortMethod(SortMethod sortMethod) {
        this.result.setMethod(sortMethod);
    }

    @Override
    public void setTimeSpent(long msec) {
        this.result.setSpent(msec);
    }

    @Override
    public void setOriginal(SortElement[] original) {
        this.result.setOriginal(original);
    }

    @Override
    public void setComplete(SortElement[] complete) {
        this.result.setComplete(complete);
    }

    @Override
    public void registStep(SortElement[] array, SortElement a, SortElement b, SortOperation ope) {

        List<SortElement> list = new ArrayList<SortElement>(2);
        list.add(a);
        list.add(b);

        registStepAsList(array, list, ope);
    }

    @Override
    public void registStepAsList(SortElement[] array, List<SortElement> list, SortOperation ope) {

        if (ope == SortOperation.COMPARING && list.size() != 2) {
            throw new IllegalStateException("list.size() should be 2.");
        } else if (ope == SortOperation.EXCHANGING && list.size() < 2) {
            throw new IllegalStateException("list.size() should be over 2.");
        }

        List<SortElement> swapList = new ArrayList<SortElement>();
        for (SortElement se : list) {
            swapList.add(new SortElement(se));
        }

        int[] valueArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            valueArray[i] = array[i].getValue();
        }

        SortStep steps = new SortStep();
        steps.setSeq(this.result.getSteps().size() + 1);
        steps.setOperation(ope);
        steps.setArray(valueArray);
        steps.setSwapElement(swapList);
        result.getSteps().add(steps);

    }

    @Override
    public void registStepToComplete(SortElement[] array, List<SortElement> list) {
        for (SortElement se : list) {
            se.setSorted(true);
        }
        registStepAsList(array, list, SortOperation.COMPLETING);
    }

    @Override
    public void updateSorted(int id, boolean sorted) {
        List<SortStep> steps = this.result.getSteps();
        steps.get(steps.size() - 1).updateSorted(id, sorted);
    };

    @Override
    public String printAll() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String json = "";
        try {
            json = mapper.writeValueAsString(this.result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return json;
    }
}
