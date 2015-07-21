package com.tefuna.toybox.sort.algorithm;

import com.tefuna.toybox.sort.AbstractSort;
import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;

public class OddEvenSort extends AbstractSort {

    private Printer printer;

    @Override
    public SortName getSortName() {
        return SortName.ODDEVEN_SORT;
    }

    @Override
    public SortMethod getSortMethod() {
        return SortMethod.EXCHANGING;
    }

    @Override
    public SortElement[] sort(SortElement[] array) {

        printer = getPrinter();
        boolean sorting = true;

        while (sorting) {
            sorting = false;

            // even element.
            for (int i = 0; i < array.length - 1; i += 2) {
                printer.registStep(array, array[i], array[i + 1], SortOperation.COMPARING);
                if (array[i].getValue() > array[i + 1].getValue()) {
                    swapSortElement(array[i], array[i + 1]);
                    printer.registStep(array, array[i], array[i + 1], SortOperation.EXCHANGING);
                    sorting = true;
                }
            }

            // odd element.
            for (int i = 1; i < array.length - 1; i += 2) {
                printer.registStep(array, array[i], array[i + 1], SortOperation.COMPARING);
                if (array[i].getValue() > array[i + 1].getValue()) {
                    swapSortElement(array[i], array[i + 1]);
                    printer.registStep(array, array[i], array[i + 1], SortOperation.EXCHANGING);
                    sorting = true;
                }
            }
        }

        return array;
    }
}
