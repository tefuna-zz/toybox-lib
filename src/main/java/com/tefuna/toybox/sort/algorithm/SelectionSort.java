package com.tefuna.toybox.sort.algorithm;

import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;
import com.tefuna.toybox.sort.AbstractSort;

public class SelectionSort extends AbstractSort {

    private Printer printer;

    @Override
    public SortName getSortName() {
        return SortName.SELECTION_SORT;
    }

    @Override
    public SortMethod getSortMethod() {
        return SortMethod.EXCHANGING;
    }

    @Override
    public SortElement[] sort(SortElement[] array) {

        printer = getPrinter();

        for (int i = 0; i < array.length; i++) {
            int minIndex = searchMinIndex(array, i);
            swapSortElement(array[i], array[minIndex]);
            array[i].setSorted(true);
            printer.setStepExchanging(array[i], array[minIndex], SortOperation.EXCHANGING);
        }

        return array;
    }

    /**
     *
     * @param array
     * @param start
     * @return
     */
    private int searchMinIndex(SortElement[] array, int start) {

        if (start >= array.length - 1) {
            return start;
        }

        int minIndex = start;
        int minValue = array[start].getValue();
        for (int i = start + 1; i < array.length; i++) {
            printer.setStepExchanging(array[start], array[i], SortOperation.COMPARING);
            if (minValue > array[i].getValue()) {
                minIndex = i;
                minValue = array[i].getValue();
            }
        }

        return minIndex;
    }

}
