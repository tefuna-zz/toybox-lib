package com.tefuna.toybox.sort;

import java.util.List;

import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;
import com.tefuna.toybox.sort.common.printer.DefaultPrinter;

abstract public class AbstractSort {

    private Printer printer;

    /**
     *
     * @param original
     * @return
     */
    public SortElement[] execute(SortElement[] original, SortElement[] array) {

        if (array == null || array.length <= 1) {
            throw new IllegalArgumentException("args error.");
        }

        if (printer == null) {
            printer = new DefaultPrinter();
        }

        printer.setSortName(getSortName());
        printer.setSortMethod(getSortMethod());
        printer.setOriginal(original);

        long start = System.currentTimeMillis();
        SortElement[] complete = sort(array);
        long end = System.currentTimeMillis();

        printer.setComplete(complete);
        printer.setTimeSpent(end - start);

        return complete;
    }

    /**
     *
     * @param array
     * @return
     */
    abstract public SortElement[] sort(SortElement[] array);

    /**
     *
     * @return
     */
    abstract public SortName getSortName();

    /**
     *
     * @return
     */
    abstract public SortMethod getSortMethod();

    /**
     *
     * @param arrayPrinter
     */
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    /**
     *
     * @return
     */
    public Printer getPrinter() {
        return this.printer;
    }

    /**
     *
     * @param a
     * @param b
     */
    protected void swapSortElement(SortElement a, SortElement b) {

        int tId = a.getId();
        int tValue = a.getValue();
        int tPosition = a.getPosition();
        // int tPosition = a.getPosition();
        // boolean tSorted = a.isSorted();

        a.setId(b.getId());
        a.setValue(b.getValue());
        a.setPrePosition(b.getPosition());

        b.setId(tId);
        b.setValue(tValue);
        b.setPrePosition(tPosition);
    }

    /**
     * for insertion.
     * 
     * @param list
     */
    protected void shiftLastElement(List<SortElement> list) {
        if (list.size() < 2) {
            throw new IllegalStateException("list size should be over 2");
        }

        for (int i = list.size() - 1; i > 0; i--) {
            swapSortElement(list.get(i), list.get(i - 1));
        }

    }
}
