package com.tefuna.toybox.sort.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;
import com.tefuna.toybox.sort.AbstractSort;

public class InsertionSort extends AbstractSort {

    private Printer printer;

    @Override
    public SortName getSortName() {
        return SortName.INSERTION_SORT;
    }

    @Override
    public SortMethod getSortMethod() {
        return SortMethod.EXCHANGING;
    }

    @Override
    public SortElement[] sort(SortElement[] array) {

        printer = getPrinter();
        List<SortElement> exchangeList = new ArrayList<SortElement>();

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                printer.registStep(array, array[j - 1], array[i], SortOperation.COMPARING);
                if (array[j - 1].getValue() > array[i].getValue()) {
                    exchangeList.add(0, array[j - 1]);
                } else {
                    break;
                }
            }

            if (exchangeList.size() > 0) {
                exchangeList.add(array[i]);
                shiftLastElement(exchangeList);

                printer.registStepAsList(array, exchangeList, SortOperation.EXCHANGING);
                exchangeList.clear();
            }
        }

        return array;
    }
}
