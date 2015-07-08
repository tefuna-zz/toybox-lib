package com.tefuna.toybox.sort.algorithm;

import com.tefuna.toybox.sort.AbstractSort;
import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;

public class ShakerSort extends AbstractSort {

    Printer printer;

    @Override
    public SortName getSortName() {
        return SortName.SHAKER_SORT;
    }

    @Override
    public SortMethod getSortMethod() {
        return SortMethod.EXCHANGING;
    }

    @Override
    public SortElement[] sort(SortElement[] array) {

        printer = getPrinter();

        int topIdx = 0;
        int btmIdx = array.length - 1;

        while (topIdx < btmIdx) {

            // from front (top).
            for (int i = topIdx; i < btmIdx; i++) {
                printer.setStepExchanging(array[i], array[i + 1], SortOperation.COMPARING);
                if (array[i].getValue() > array[i + 1].getValue()) {
                    swapSortElement(array[i], array[i + 1]);
                    printer.setStepExchanging(array[i], array[i + 1], SortOperation.EXCHANGING);
                }
            }
            printer.updateSorted(array[btmIdx].getId(), true);
            topIdx++;

            // if all elements of arrays are scanned.
            if (topIdx >= btmIdx) {
                break;
            }

            // from back (bottom).
            for (int i = btmIdx - 1; i > topIdx - 1; i--) {
                printer.setStepExchanging(array[i - 1], array[i], SortOperation.COMPARING);
                if (array[i - 1].getValue() > array[i].getValue()) {
                    swapSortElement(array[i - 1], array[i]);
                    printer.setStepExchanging(array[i - 1], array[i], SortOperation.EXCHANGING);
                }
            }
            printer.updateSorted(array[topIdx - 1].getId(), true);
            btmIdx--;
        }

        return array;
    }
}
