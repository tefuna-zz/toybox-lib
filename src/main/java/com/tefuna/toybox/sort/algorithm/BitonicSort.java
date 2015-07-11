package com.tefuna.toybox.sort.algorithm;

import com.tefuna.toybox.sort.AbstractSort;
import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.constant.SortOrder;
import com.tefuna.toybox.sort.common.constant.SortProperty;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;

public class BitonicSort extends AbstractSort {

    Printer printer;
    SortElement[] all;

    @Override
    public SortName getSortName() {
        return SortName.BITONIC_SORT;
    }

    @Override
    public SortMethod getSortMethod() {
        return SortMethod.EXCHANGING;
    }

    @Override
    public SortElement[] sort(SortElement[] array) {

        printer = getPrinter();
        all = array;
        
        return sortBitonic(array, SortOrder.ASC);
    }

    /**
     * 
     * @param array
     * @param order
     * @return
     */
    private SortElement[] sortBitonic(SortElement[] bitArray, SortOrder order) {

        if (bitArray.length <= 1) {
            return bitArray;
        }

        SortElement[] front = sortBitonic(getHalfArray(bitArray, true), SortOrder.ASC);
        SortElement[] back = sortBitonic(getHalfArray(bitArray, false), SortOrder.DESC);
        return mergeBitonic(getMergedArray(front, back), order);
    }

    /**
     * 
     * @param bitArray
     * @param order
     * @return
     */
    private SortElement[] mergeBitonic(SortElement[] bitArray, SortOrder order) {

        if (bitArray.length == 1) {
            return bitArray;
        }

        swapBitonic(bitArray, order);
        SortElement[] front = mergeBitonic(getHalfArray(bitArray, true), order);
        SortElement[] back = mergeBitonic(getHalfArray(bitArray, false), order);

        return getMergedArray(front, back);
    }

    /**
     * 
     * @param array
     * @param order
     */
    private void swapBitonic(SortElement[] bitArray, SortOrder order) {

        int dist = bitArray.length / 2;
        for (int i = 0; i < dist; i++) {
            printer.registStep(this.all, bitArray[i], bitArray[i + dist], SortOperation.COMPARING);
            if ((order == SortOrder.ASC && bitArray[i].getValue() > bitArray[i + dist].getValue())
                    || (order == SortOrder.DESC && bitArray[i].getValue() < bitArray[i + dist].getValue())) {
                swapSortElement(bitArray[i], bitArray[i + dist]);
                printer.registStep(this.all, bitArray[i], bitArray[i + dist], SortOperation.EXCHANGING);
            }
        }
    }

    /**
     * 
     * @param srcArray
     * @param isFront
     * @return
     */
    private SortElement[] getHalfArray(SortElement[] bitArray, boolean front) {

        int start = 0;
        SortElement[] half = new SortElement[bitArray.length / 2];

        if (!front) {
            start = bitArray.length / 2;
        }

        for (int i = 0; i < half.length; i++) {
            half[i] = bitArray[i + start];
        }

        return half;
    }

    /**
     * 
     * @param front
     * @param back
     * @return
     */
    private SortElement[] getMergedArray(SortElement[] front, SortElement[] back) {

        SortElement[] merged = new SortElement[front.length + back.length];
        for (int i = 0; i < front.length; i++) {
            merged[i] = front[i];
        }
        for (int i = 0; i + front.length < merged.length; i++) {
            merged[i + front.length] = back[i];
        }

        return merged;
    }
}
