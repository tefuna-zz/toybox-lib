package com.tefuna.toybox.sort.common.printer;

import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.element.SortResult;

/**
 *
 * @author tefuna
 *
 */
public class DefaultPrinter implements Printer {

    SortResult result = new SortResult();

    @Override
    public void setArray(SortElement[] array) {

        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < array.length - 1; i++) {
            builder.append(array[i]);
            builder.append(", ");
        }
        builder.append(array[array.length - 1]);
        builder.append("]");

        System.out.println("array: " + builder.toString());
    }

    @Override
    public void setStepExchanging(SortElement a, SortElement b, SortOperation ope) {

        StringBuilder builder = new StringBuilder("[");
        builder.append(a.toString() + ", ");
        builder.append(b.toString() + ", ");
        builder.append(ope.toString() + "]");

        System.out.println("step: " + builder.toString());
    }

    @Override
    public void setStepInsertion(SortElement[] array, int from, int to) {

        // @TODO

    }

    @Override
    public void setSortName(SortName sortName) {
        System.out.println("name: " + sortName.name());
    }

    @Override
    public void setSortMethod(SortMethod sortMethod) {
        System.out.println("method: " + sortMethod.name());
    }

    @Override
    public void setTimeSpent(long msec) {
        System.out.println("spent: " + msec);
    }

    @Override
    public void setOriginal(SortElement[] original) {
        setArray(original);
    }

    @Override
    public void setComplete(SortElement[] complete) {
        setArray(complete);
    }

    @Override
    public void updateSorted(int id, boolean sorted) {
        System.out.println("undefined method: " + this.getClass().getCanonicalName() + "#updateMethod");
    };

    @Override
    public String printAll() {
        System.out.println("undefined method: " + this.getClass().getCanonicalName() + "#printAll");
        return null;
    }

}
