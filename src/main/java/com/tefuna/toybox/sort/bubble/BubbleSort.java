package com.tefuna.toybox.sort.bubble;

import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;
import com.tefuna.toybox.sort.AbstractSort;

/**
 *
 * @author tefuna
 *
 */
public class BubbleSort extends AbstractSort {

    private Printer printer;

    @Override
    public SortName getSortName() {
        return SortName.BUBBLE_SORT;
    }

    @Override
    public SortMethod getSortMethod() {
        return SortMethod.EXCHANGING;
    }

    @Override
    public SortElement[] sort(SortElement[] array) {

        printer = getPrinter();
        for (int i = 0; i < array.length; i++) {
            int j = 0;
            for (j = 0; j < array.length - 1 - i; j++) {
                if (array[j].getValue() > array[j + 1].getValue()) {
                    swapSortElement(array[j], array[j + 1]);
                    printer.setStepExchanging(array[j], array[j + 1], SortOperation.EXCHANGING);
                } else {
                    printer.setStepExchanging(array[j], array[j + 1], SortOperation.COMPARING);
                }
            }
            array[j].setSorted(true);
            printer.updateSorted(array[j].getId(), true);
            // this.getArrayPrinter().printArray(array);
        }

        return array;
    }
}
