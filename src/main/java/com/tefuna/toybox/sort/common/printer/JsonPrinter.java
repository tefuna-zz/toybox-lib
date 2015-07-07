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
import com.tefuna.toybox.sort.common.element.SortSteps;
import com.tefuna.toybox.sort.common.element.SortStepsExchanging;

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
    public void setArray(SortElement[] array) {
        // TODO
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
    public void setStepExchanging(SortElement a, SortElement b, SortOperation ope) {

        int nextSeq = this.result.getSteps().size() + 1;

        if (this.result.getMethod() == null) {
            throw new IllegalStateException("cannot call before sort method.");
        }

        switch (this.result.getMethod()) {
        case EXCHANGING:
            SortStepsExchanging stepsEx = new SortStepsExchanging();

            List<SortElement> swapList = new ArrayList<SortElement>();
            swapList.add(new SortElement(a));
            swapList.add(new SortElement(b));

            stepsEx.setSeq(nextSeq);
            stepsEx.setOperation(ope);
            stepsEx.setSwapElement(swapList);
            result.getSteps().add(stepsEx);

            break;
        default:
            throw new IllegalStateException("unexpected sort method.");
        }
    }


    @Override
    public void setStepInsertion(SortElement[] array, int from, int to) {

        int nextSeq = this.result.getSteps().size() + 1;

        if (this.result.getMethod() == null) {
            throw new IllegalStateException("cannot call before sort method.");
        }

        switch (this.result.getMethod()) {
        case EXCHANGING:
            SortStepsExchanging stepsEx = new SortStepsExchanging();

            List<SortElement> swapList = new ArrayList<SortElement>();

            for (int i = from; i >= to; i--) {
                swapList.add(new SortElement(array[i]));
            }
            stepsEx.setSeq(nextSeq);
            stepsEx.setOperation(SortOperation.EXCHANGING);
            stepsEx.setSwapElement(swapList);
            result.getSteps().add(stepsEx);

            break;
        default:
            throw new IllegalStateException("unexpected sort method.");
        }
    }


    @Override
    public void updateSorted(int id, boolean sorted) {
        List<SortSteps> steps = this.result.getSteps();
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
