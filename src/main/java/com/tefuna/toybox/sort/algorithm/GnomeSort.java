package com.tefuna.toybox.sort.algorithm;

import com.tefuna.toybox.sort.AbstractSort;
import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;

public class GnomeSort extends AbstractSort {

    Printer printer;

    @Override
    public SortName getSortName() {
        return SortName.GNOME_SORT;
    }

    @Override
    public SortMethod getSortMethod() {
        return SortMethod.EXCHANGING;
    }

    @Override
    public SortElement[] sort(SortElement[] array) {

        printer = getPrinter();

        int i = 1;
        int pos = 1;
        while (i < array.length) {
            printer.registStep(array, array[i - 1], array[i], SortOperation.COMPARING);
            if (array[i - 1].getValue() > array[i].getValue()) {
                swapSortElement(array[i - 1], array[i]);
                printer.registStep(array, array[i - 1], array[i], SortOperation.EXCHANGING);

                i--;
                if (i == 0) {
                    i++;
                }
            } else {
                pos++;
                i = pos;
            }
        }

        return array;
    }
}
