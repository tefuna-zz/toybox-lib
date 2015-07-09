package com.tefuna.toybox.sort.common.printer;

import java.util.List;

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
    public void registStep(SortElement[] array, SortElement a, SortElement b, SortOperation ope) {

        StringBuilder builder = new StringBuilder("[");
        builder.append(a.toString() + ", ");
        builder.append(b.toString() + ", ");
        builder.append(ope.toString() + "]");

        System.out.println("step: " + builder.toString());
    }

    @Override
    public void registStepAsList(SortElement[] array, List<SortElement> list, SortOperation ope) {
        // TODO
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
        printArray(original);
    }

    @Override
    public void setComplete(SortElement[] complete) {
        printArray(complete);
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

    private void printArray(SortElement[] array) {
        // TODO
        System.out.println("printArray(); implementation later.");
    }

}
