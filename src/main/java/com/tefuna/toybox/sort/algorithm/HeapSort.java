package com.tefuna.toybox.sort.algorithm;

import com.tefuna.toybox.sort.AbstractSort;
import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;

public class HeapSort extends AbstractSort {

    private Printer printer;

    @Override
    public SortName getSortName() {
        return SortName.HEAP_SORT;
    }

    @Override
    public SortMethod getSortMethod() {
        return SortMethod.EXCHANGING;
    }

    @Override
    public SortElement[] sort(SortElement[] array) {

        printer = getPrinter();

        for (int i = 0; i < array.length; i++) {
            upHeap(array, i);
        }

        for (int i = array.length - 1; i > 0; i--) {
            swapSortElement(array[0], array[i]);
            printer.registStep(array, array[0], array[i], SortOperation.EXCHANGING);
            // TODO mark sorted
//            printer.updateSorted(, sorted);
            downHeap(array, i);
        }

        return array;
    }

    /**
     * 
     * @param array
     * @param index
     */
    private void upHeap(SortElement[] array, int index) {

        while (index > 0) {
            int pIndex = getParent(index);

            printer.registStep(array, array[index], array[pIndex], SortOperation.COMPARING);
            if (array[index].getValue() > array[pIndex].getValue()) {
                swapSortElement(array[index], array[pIndex]);
                printer.registStep(array, array[index], array[pIndex], SortOperation.EXCHANGING);
            } else {
                break;
            }

            index = pIndex;
        }
    }

    /**
     * 
     * @param array
     * @param index
     */
    private void downHeap(SortElement[] array, int index) {
        int pIndex = 0;
        int temp = 0;

        while (true) {
            int lcIndex = getChildLeft(pIndex);
            int rcIndex = getChildRight(pIndex);

            if (lcIndex >= index) {
                break;
            }

            printer.registStep(array, array[lcIndex], array[temp], SortOperation.COMPARING);
            if (array[lcIndex].getValue() > array[temp].getValue()) {
                temp = lcIndex;
            }

            printer.registStep(array, array[rcIndex], array[temp], SortOperation.COMPARING);
            if (rcIndex < index && array[rcIndex].getValue() > array[temp].getValue()) {
                temp = rcIndex;
            }

            if (temp == pIndex) {
                break;
            }

            swapSortElement(array[temp], array[pIndex]);
            printer.registStep(array, array[temp], array[pIndex], SortOperation.EXCHANGING);
            pIndex = temp;
        }

        return;
    }

    private static int getParent(int index) {
        return ((index + 1) / 2) - 1;
    }

    private static int getChildLeft(int index) {
        return ((index + 1) * 2) - 1;
    }

    private static int getChildRight(int index) {
        return ((index + 1) * 2);
    }

}
