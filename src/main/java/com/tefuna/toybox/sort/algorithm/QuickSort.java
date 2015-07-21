package com.tefuna.toybox.sort.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.tefuna.toybox.sort.AbstractSort;
import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;

public class QuickSort extends AbstractSort {

    Printer printer;

    @Override
    public SortName getSortName() {
        return SortName.QUICK_SORT;
    }

    @Override
    public SortMethod getSortMethod() {
        return SortMethod.EXCHANGING;
    }

    @Override
    public SortElement[] sort(SortElement[] array) {

        printer = getPrinter();
        sortQuick(array, 0, array.length - 1);

        return array;
    }

    /**
     * 
     * @param array
     * @param left
     * @param right
     * @return
     */
    private void sortQuick(SortElement[] array, int left, int right) {

        if (left >= right) {
            return;
        }

        int i = left, j = right;
        SortElement pivot = getPivot(array[i], array[i + (j - i) / 2], array[j]);
        int pivotVal = pivot.getValue();

        while (true) {
            printer.registStep(array, array[i], pivot, SortOperation.COMPARING);
            while (array[i].getValue() < pivotVal) {
                i++;
                printer.registStep(array, array[i], pivot, SortOperation.COMPARING);
            }

            printer.registStep(array, pivot, array[j], SortOperation.COMPARING);
            while (pivotVal < array[j].getValue()) {
                j--;
                printer.registStep(array, pivot, array[j], SortOperation.COMPARING);
            }
            if (i >= j) {
                break;
            }
            swapSortElement(array[i], array[j]);
            printer.registStep(array, array[i], array[j], SortOperation.EXCHANGING);
            i++;
            j--;
        }

        sortQuick(array, left, i - 1);
        sortQuick(array, j + 1, right);

        // here, left to right element is completed sort.
        List<SortElement> list = new ArrayList<SortElement>();
        for (int x = left; x <= right; x++) {
            list.add(array[x]);
        }
        printer.registStepToComplete(array, list);

        return;
    }

    /**
     * get median.
     * 
     * @param x
     * @param y
     * @param z
     * @return
     */
    private SortElement getPivot(SortElement x, SortElement y, SortElement z) {

        if (x.getValue() < y.getValue()) {
            if (y.getValue() < z.getValue()) {
                return y;
            } else if (x.getValue() < z.getValue()) {
                return z;
            } else {
                return x;
            }
        } else { // x is bigger than y;
            if (x.getValue() < z.getValue()) {
                return x;
            } else if (y.getValue() < z.getValue()) {
                return z;
            } else { // x is bigger than y and y is bigger than z;
                return y;
            }
        }
    }
}
