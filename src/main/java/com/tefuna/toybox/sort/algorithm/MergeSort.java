package com.tefuna.toybox.sort.algorithm;

import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;
import com.tefuna.toybox.sort.AbstractSort;

public class MergeSort extends AbstractSort {

    private Printer printer;
    private SortElement[] all;

    @Override
    public SortName getSortName() {
        return SortName.MERGE_SORT;
    }

    @Override
    public SortMethod getSortMethod() {
        return SortMethod.EXCHANGING;
    }

    @Override
    public SortElement[] sort(SortElement[] array) {

        printer = getPrinter();
        all = array;

        array = sortMerge(array);
        return array;
    }

    /**
     * 
     *
     * @return
     */
    private SortElement[] sortMerge(SortElement[] array) {

        if (array.length <= 1) {
            return array;
        }

        // devide array.
        SortElement[] front = new SortElement[array.length / 2];
        for (int i = 0; i < front.length; i++) {
            front[i] = array[i];
        }

        SortElement[] back = new SortElement[array.length - (array.length / 2)];
        for (int i = 0; i < back.length; i++) {
            back[i] = array[front.length + i];
        }

        front = sortMerge(front);
        back = sortMerge(back);

        return merge(front, back);

    }

    /**
     * 
     * @param a
     * @param b
     * @return
     */
    private SortElement[] merge(SortElement[] a, SortElement[] b) {

        SortElement[] merged = new SortElement[a.length + b.length];
        int[] posArray = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            posArray[i] = a[i].getPosition();
        }
        for (int i = 0; i < b.length; i++) {
            posArray[i + a.length] = b[i].getPosition();
        }

        int i = 0, j = 0;
        while (i + j < merged.length) {
            if (i < a.length && j < b.length) {
                printer.registStep(all, a[i], b[j], SortOperation.COMPARING);
                if (a[i].getValue() <= b[j].getValue()) {
                    merged[i + j] = a[i];
                    merged[i + j].setPrePosition(merged[i + j].getPosition());
                    merged[i + j].setPosition(posArray[i + j]);
                    printer.registStep(all, merged[i + j], a[i], SortOperation.EXCHANGING);
                    i++;
                } else {
                    merged[i + j] = b[j];
                    merged[i + j].setPrePosition(merged[i + j].getPosition());
                    merged[i + j].setPosition(posArray[i + j]);
                    printer.registStep(all, merged[i + j], b[j], SortOperation.EXCHANGING);
                    j++;
                }
            } else if (i >= a.length) {
                merged[i + j] = b[j];
                merged[i + j].setPrePosition(merged[i + j].getPosition());
                merged[i + j].setPosition(posArray[i + j]);
                printer.registStep(all, merged[i + j], b[j], SortOperation.EXCHANGING);
                j++;
            } else if (j >= b.length) {
                merged[i + j] = a[i];
                merged[i + j].setPrePosition(merged[i + j].getPosition());
                merged[i + j].setPosition(posArray[i + j]);
                printer.registStep(all, merged[i + j], a[i], SortOperation.EXCHANGING);
                i++;
            } else {
                throw new IllegalStateException("merged size over.");
            }
        }

        return merged;
    }
}
